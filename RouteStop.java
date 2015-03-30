import java.util.*;

public class RouteStop
{
    private ClientDirection direction;
    private LinkedList<Client> clients;
    private int index;
    
    public RouteStop(ClientDirection direction, Client client, int index)
    {
        this.direction = direction;
        this.index = index;
        
        this.clients = new LinkedList<Client>();
        this.clients.add(client);
    }
    
   public void addClient(Client client)
   {
       this.clients.add(client);
   }
    
    public String toString() {
        String header = (direction == ClientDirection.ON) ? "On" : "Off";
        return header + ": " + showClients();
    }
    
    public String showClients()
    {
        String result = "";
        
        for(Client client: clients)
        {
            result += client.name() + client.id() + " ";
        }
        
        return result.trim();
    }
    
    public int index()
    {
        return this.index;
    }
}
