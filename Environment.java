import java.util.LinkedList;

public class Environment
{
    private Repository repository = null;
    
    public Environment(Repository repository) {
        this.repository = repository;
    }
    
    public LinkedList<RouteResponse> run() {
        LinkedList<RouteResponse> result = new LinkedList<RouteResponse>();
        
        for(Boat boat: repository.allBoats())
        {
            RouteResponse route = GetRouteResponseFrom(boat);
            result.add(route);
        }
        
        return result;
    }
    
    public RouteResponse GetRouteResponseFrom(Boat boat) 
    {
        RouteResponse result = new RouteResponse(boat);
        
        for (int stop = 0; stop <= boat.stops; stop++)
        {
            for (Trip trip: boat.trips)
            {
                Client client = trip.client;
                if (stop == trip.start())
                {
                    result.addStop(ClientDirection.ON, client, stop);
                }
                
                if (stop == trip.end())
                {
                    result.addStop(ClientDirection.OFF, client, stop);
                }
            }
        }
        
        return result;
    }
}
