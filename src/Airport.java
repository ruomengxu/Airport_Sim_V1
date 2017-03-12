//YOUR NAME HERE

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Airport implements EventHandler {

    //TODO add landing and takeoff queues, random variables

    private int m_inTheAir;
    private int m_onTheGround;

    private boolean m_freeToLand;
    //airport code
    private int airport_code;
    // flow population stat
    private int landing_flow;
    private int depart_flow;
    //circle time
    private Queue<Double> ArrivalQueue;
    private Double circle_time;
    //landingqueue and takeoffqueue
    private Queue<Airplane> LandingQueue;
    private Queue<Airplane> TakeoffQueue;


    private double m_flightTime;
    private double m_runwayTimeToLand;
    private double m_requiredTimeOnGround;

    private String m_airportName;
    public Airport(String name, double runwayTimeToLand, double requiredTimeOnGround, double flightTime,int code) {
        m_airportName = name;
        m_inTheAir =  0;
        m_onTheGround = 0;
        m_freeToLand = true;
        m_runwayTimeToLand = runwayTimeToLand;
        m_requiredTimeOnGround = requiredTimeOnGround;
        m_flightTime = flightTime;
        //initialize queue
        LandingQueue = new LinkedList<Airplane>();
        TakeoffQueue = new LinkedList<Airplane>();
        //initialize code
        airport_code = code;
        //initialize pop
        landing_flow=0;
        depart_flow=0;
        circle_time=0.0;
        //initialize circle time
        ArrivalQueue=new LinkedList<Double>();


    }

    public String getName() {
        return m_airportName;
    }
    public int getCode(){return airport_code;}
    public int getLanding_flow(){return landing_flow;}
    public int getDepart_flow(){return depart_flow;}
    public double getCircleTime(){return circle_time;}

    public void handle(Event event) {
        java.text.DecimalFormat df =new java.text.DecimalFormat("#.00");
        AirportEvent airEvent = (AirportEvent)event;
        switch(airEvent.getType()) {
            case AirportEvent.PLANE_ARRIVES:
                m_inTheAir++;
                //add arrival time into queue
                ArrivalQueue.add(Simulator.getCurrentTime());
                //add arrival airplane into Landingqueue
                LandingQueue.add(airEvent.getAirplane());
                //update population flow
                landing_flow+=airEvent.getAirplane().getPassenger();
                //broadcast
                System.out.println(df.format(Simulator.getCurrentTime()) + ": " +airEvent.getAirplane().getName()+ " arrives at airport "+ m_airportName );
                if(m_freeToLand) {
                    AirportEvent landedEvent = new AirportEvent(m_runwayTimeToLand, this, AirportEvent.PLANE_LANDED,airEvent.getAirplane());
                    Simulator.schedule(landedEvent);
                    //set runway to false
                    m_freeToLand=false;
                }
                break;

            case AirportEvent.PLANE_DEPARTS:
                m_onTheGround--;
                //update takeoffqueue when depart
                TakeoffQueue.remove();
                //generate random for airport and passenger
                Random ran=new Random();
                int ran_code = ran.nextInt(5);
                //destination cannot be the same
                while (ran_code==airport_code){
                    ran_code=ran.nextInt(5);
                }
                int passenger = ran.nextInt(100)+airEvent.getAirplane().getCapacity()-100;
                Airport arrival_airport = AirportSim.airports[ran_code];
                System.out.println(df.format(Simulator.getCurrentTime()) + ": " +airEvent.getAirplane().getName()+ " departs from airport "+ m_airportName);
                //calculate fly time
                Double air_time = AirportSim.dis[arrival_airport.getCode()][this.getCode()]/airEvent.getAirplane().getSpeed();
                //update passenger
                airEvent.getAirplane().UpdatePassenger(passenger);
                //update population stat
                depart_flow+=airEvent.getAirplane().getPassenger();
                AirportEvent takeoffEvent = new AirportEvent(m_flightTime+air_time, arrival_airport, AirportEvent.PLANE_ARRIVES,airEvent.getAirplane());
                Simulator.schedule(takeoffEvent);
                break;

            case AirportEvent.PLANE_LANDED:
                m_inTheAir--;
                m_onTheGround++;
                //update landingqueue and takeoffqueue
                LandingQueue.remove();
                TakeoffQueue.add(airEvent.getAirplane());
                //circile time = landingtime-arrivaltime-runwaytime
                circle_time=circle_time + Simulator.getCurrentTime()-ArrivalQueue.remove()-m_runwayTimeToLand;
                System.out.println(df.format(Simulator.getCurrentTime()) + ": "  +airEvent.getAirplane().getName()+ " lands at airport " + m_airportName );
                AirportEvent departureEvent = new AirportEvent(m_requiredTimeOnGround, this, AirportEvent.PLANE_DEPARTS,airEvent.getAirplane());
                Simulator.schedule(departureEvent);
                if(m_inTheAir != 0)
                {
                    Airplane airplane_q = LandingQueue.peek();
                    AirportEvent landingEvent = new AirportEvent(m_runwayTimeToLand, this, AirportEvent.PLANE_LANDED,airplane_q);
                    Simulator.schedule(landingEvent);
                }
                else
                {
                    m_freeToLand = true;
                }
                break;
        }
    }
}
