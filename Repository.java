import java.util.LinkedList;

public class Repository
{
    private LinkedList<Boat> boats;
    private LinkedList<Client> clients;
    
    public Repository() {
        boats = new LinkedList<Boat>();
        clients = new LinkedList<Client>();
    }
    
    /*
     * seed data used for testing and developement.
     */
    public void seed() {
        createBoat(3, new Driver(0, "Ed"));
        createBoat(6, new Driver(1, "Fred"));
        createBoat(5, new Driver(2, "Freda"));
        
        Client bart = createClient("Homer");
        createClient("Marge");
        
        //Trip trip = new Trip(bart, 1, 2);
        
        //Boat boat = findBoatByIndex(1);
        //boat.addTrip(trip);
    }
    
    /*
     * Load models from disk
     */
    public boolean read() {
        return false;
    }
    
    /*
     * Save models to disk
     */
    public boolean persist() {
        return false;
    }
    
    public LinkedList<Client> allClients() {
        return clients;
    }
    
    public Client findClientByName(String name) {
        for(Client client: clients) {
            if (client.name == name) return client;
        }
        
        return null;
    }
    
    public Client findClientById(String id) {
       for(Client client: clients) {
           //System.out.println("client: " + client.id);
           if (client.id().equals(id)) return client;
        }
        
        return null;
    }
    
    public Client findClientByNameAndId(String key)
    {
        for(Client client: clients) {
           //System.out.println("client: " + client.id);
           //if (client.id.equals(id)) return client;
           if (key.startsWith(client.name()))
           {
               String id = key.split(client.name())[1];
               //System.out.println("id: " + id);
               
               if (client.id().equals(id)) return client;
           }
        }
        
        return null;
    }
    
    public Client createClient(String name) {
        int index       = clients.size();
        Client client   = new Client(name);
        
        clients.add(client);
        
        return client;
    }
    
    public StandardResponse deleteClient(String key) {
        Client client = findClientByNameAndId(key);
        if (client == null) return StandardResponse.Fail("No such client");
        
        clients.remove(client);
        return StandardResponse.OK();
    }

    
    public Boat findBoatByIndex(int index) {
        if (index > boats.size()) return null;
        return boats.get(index);
    }
   
    public Boat createBoat(int stops, Driver driver) {
        Boat boat = new Boat(driver, stops);
        boats.add(boat);
        return boat;
    }
    
    public LinkedList<Boat> allBoats() {
        return boats;
    }
}
