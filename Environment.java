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
        for (int stop = 0; stop <= boat.stops(); stop++)
        {
            int count = 0;
            for (Trip trip: boat.trips())
            {
                Client client = trip.client;
                trip.isCharged = false;
                
                if (stop == trip.start())
                {
                    result.addStop(ClientDirection.ON, client, stop);
                }
                
                if (stop == trip.end())
                {
                    result.addStop(ClientDirection.OFF, client, stop);
                    
                }
                
                
                if (trip.start() <= stop && trip.end() > stop)
                {
                    count++;
                    trip.isCharged = true;
                }
              
            }
            
            if (count == 0) continue;
            
            for(Trip trip: boat.trips())
            {
                if (!trip.isCharged) continue;
                trip.client.charge(10 / count);
            }
        }
        
        return result;
    }
}
