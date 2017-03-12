//YOUR NAME HERE

//TODO add number of passengers, speed

public class Airplane {
    private String m_name;
    //capacity, number of passenger, speed
    private int m_passenger;
    private int m_capacity;
    private double m_speed;

    public Airplane(String name,int max_Passengers,int current_Passenger,double speed)
    {
        m_name = name;
        //initialize
        m_capacity = max_Passengers;
        m_passenger = current_Passenger;
        m_speed = speed;
    }
    public String getName() {
        return m_name;
    }
    //get capacity and speed and number of current passenger
    public int getCapacity(){
        return m_capacity;
    }
    public double getSpeed(){
        return m_speed;
    }
    public int getPassenger() {return m_passenger;}
    public void UpdatePassenger(int passenger){
        m_passenger=passenger;
    }

}
