//YOUR NAME HERE

public class AirportEvent extends Event {
    public static final int PLANE_ARRIVES = 0;
    public static final int PLANE_LANDED = 1;
    public static final int PLANE_DEPARTS = 2;
    //add airplane in AirportEvent
    public Airplane airplane;
    //
    AirportEvent(double delay, EventHandler handler, int eventType, Airplane airplane_) {
        super(delay, handler, eventType);
        this.airplane=airplane_;
    }
    //get Airplane
    public Airplane getAirplane(){
        return airplane;
    }
}
