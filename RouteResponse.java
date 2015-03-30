import java.util.LinkedList;

public class RouteResponse
{
    public Boat boat;
    public LinkedList<RouteStop> stops;
    private RouteStop last;
    
    public RouteResponse(Boat b) {
        boat    = b;
        stops   = new LinkedList<RouteStop>();
    }
    
    public void addStop(ClientDirection direction, Client client, int index)
    {
        if (last != null && last.index() == index)
        {
            last.addClient(client);
            return;
        }
        
        RouteStop stop = new RouteStop(direction, client, index);
        stops.add(stop);
        last = stop;
    }
    
    public int stopsCount()
    {
        return stops.size();
    }
}