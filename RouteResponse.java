import java.util.LinkedList;

public class RouteResponse
{
    public Boat boat;
    public LinkedList<RouteStop> stops;
    
    public RouteResponse(Boat b) {
        boat    = b;
        stops   = new LinkedList<RouteStop>();
    }
    
    public void addStop(ClientDirection direction, Client client)
    {
        RouteStop stop = new RouteStop(direction, client);
        stops.add(stop);
    }
}