import java.util.LinkedList;

public class Environment
{
    private Repository repository = null;
    
    public Environment(Repository repository) {
        repository = repository;
    }
    
    public StandardResponse makeBooking(String clientId, String boatIdx, int start, int end) {
        return null;
    }
    
    public LinkedList<RouteResponse> run() {
        return null;
    }
}
