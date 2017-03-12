//YOUR NAME HERE

import java.util.Random;
import java.util.TreeSet;


public class AirportSim {
    // Define and Initialize Airport array, distance matrix, airplane array
    public static Airport[] airports = new Airport[5];
    public static Double[][] dis = new Double[5][5];
    public static Airplane[] airplanes = new Airplane[8];
    public AirportSim(){
        airports[0] = new Airport("LAX", 10, 20, 20,0);
        airports[1] = new Airport("ATL", 5,8,15,1);
        airports[2] = new Airport("JFK", 12,10,22,2);
        airports[3] = new Airport("SFO", 6, 7,18,3);
        airports[4] = new Airport("DCA", 8,9, 17,4);
        dis[0][1]=dis[1][0]=2197.8;
        dis[0][2]=dis[2][0]=2475.0;
        dis[0][3]=dis[3][0]=338.0;
        dis[0][4]=dis[4][0]=2311.0;
        dis[1][2]=dis[2][1]=760.1;
        dis[1][3]=dis[3][1]=2468.7;
        dis[1][4]=dis[4][1]=645.0;
        dis[2][3]=dis[3][2]=2586.0;
        dis[2][4]=dis[4][2]=213.0;
        dis[3][4]=dis[4][3]=2442.0;
        dis[0][0]=dis[1][1]=dis[2][2]=dis[3][3]=dis[4][4]=0.0;
        Random ran=new Random();
        int[] passenger=new int[8];
        for(int i=0;i<8;i++)
        {
            passenger[i]=ran.nextInt(101)+400;
        }
        airplanes[0]= new Airplane("Airplane1",500, passenger[0],575);
        airplanes[1]= new Airplane("Airplane2", 525, passenger[1],600);
        airplanes[2]= new Airplane("Airplane3", 505, passenger[2],542);
        airplanes[3]= new Airplane("Airplane4", 530, passenger[3],588);
        airplanes[4]= new Airplane("Airplane5", 600,passenger[4],534);
        airplanes[5]= new Airplane("Airplane6", 520,passenger[5],577);
        airplanes[6]= new Airplane("Airplane7", 555,passenger[6],561);
        airplanes[7]= new Airplane("Airplane8", 500,passenger[7],512);


    }


    public static void main(String[] args) {

        AirportSim airportSim=new AirportSim();
        AirportEvent[] landingEvents = new AirportEvent[8];
        //initialize landing events
        landingEvents[0] = new AirportEvent(5, airports[0], AirportEvent.PLANE_ARRIVES,airplanes[0]);
        landingEvents[1] = new AirportEvent(5, airports[1], AirportEvent.PLANE_ARRIVES,airplanes[1]);
        landingEvents[2] = new AirportEvent(4, airports[2], AirportEvent.PLANE_ARRIVES,airplanes[2]);
        landingEvents[3] = new AirportEvent(8, airports[3], AirportEvent.PLANE_ARRIVES,airplanes[3]);
        landingEvents[4] = new AirportEvent(7, airports[4], AirportEvent.PLANE_ARRIVES,airplanes[4]);
        landingEvents[5] = new AirportEvent(4, airports[0], AirportEvent.PLANE_ARRIVES,airplanes[5]);
        landingEvents[6] = new AirportEvent(10, airports[1], AirportEvent.PLANE_ARRIVES,airplanes[6]);
        landingEvents[7] = new AirportEvent(5, airports[2], AirportEvent.PLANE_ARRIVES,airplanes[7]);



        for (int i=0;i<8;i++) {
            Simulator.schedule(landingEvents[i]);
        }

        Simulator.stopAt(80);
        Simulator.run();
        java.text.DecimalFormat df = new  java.text.DecimalFormat("#.00");
        for(int i=0;i<5;i++){
            System.out.println(airports[i].getName()+" Landing Flow: " + airports[i].getLanding_flow() +"; Departure Flow: " +airports[i].getDepart_flow()+ "; Circle Time: "+ df.format(airports[i].getCircleTime()));
        }

    }
}
