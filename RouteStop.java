public class RouteStop
{
    public ClientDirection direction;
    public Client client;
    
    public RouteStop(ClientDirection direction, Client client)
    {
        this.direction = direction;
        this.client = client;
    }
    
    public String toString() {
        String header = (direction == ClientDirection.ON) ? "On" : "Off";
        return header + ": " + client.id;
    }
}
