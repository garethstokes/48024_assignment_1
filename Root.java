import java.util.LinkedList;
import java.text.*;
import java.io.*;

public class Root
{
    private Store store;
    private Repository repository;
    private Environment environment;
    
    public static void main(String[] args) {
        new Root();
    }
    
    public Root() {
        store       = new Store();
        repository  = store.read();
        environment = new Environment(repository);

        char c = choice();
        
        while (c != 'x') {
            if (c == 'f') {
                // store and exit
                System.out.println("  Stored to file");
                try
                {
                    store.persist();
                }
                catch(IOException e)
                {
                    System.out.println(e.toString());
                }
                return;
            }
            
            route(c);
            c = choice();
        }
    }
    
    public void route(char options) {
        switch(options) {
            case 'a': 
                //System.out.println("add a client");
                addClient();
                return;
                
            case 'r':
                //System.out.println("remove a client");
                removeClient();
                return;
                
            case 'b':
                //System.out.println("make a booking");
                makeBooking();
                return;
                
            case 'g': 
                //System.out.println("run the boats");
                runBoats();
                return;
                
            case 's': 
                //System.out.println("show the clients");
                showClients();
                return;
               
            default:
                menu();
        }
    }
    
    public char choice() {
        System.out.print("Your choice: ");
        return In.nextChar();
    }
    
    public void menu() {
        System.out.println("The menu choices are");
        System.out.println("  a: add a client");
        System.out.println("  r: remove a client");
        System.out.println("  b: make a booking");
        System.out.println("  g: go (run the boats)");
        System.out.println("  s: show the clients");
        System.out.println("  f: store and exit");
        System.out.println("  x: exit");
    }
    
    public void showClients()
    {
        for(Client client: repository.allClients())
        {
            System.out.println("  " + client.name() + " (" + client.toString() + ") has $" + formatted(client.balance()));
        }
    }
    
    private String formatted(double amount)
    {   
        DecimalFormat twoD = new DecimalFormat("###,##0.00");
        return twoD.format(amount);  
    }
    
    private void addClient() 
    {
        System.out.print("  Name: ");
        String name = In.nextLine();
        
        Client client = repository.createClient(name);
        System.out.println("    Hi " + client.name() + ", you are " + client.toString());
    }
    
    private void removeClient() {
        System.out.print("  Name: ");
        String name = In.nextLine();
        
        StandardResponse response = repository.deleteClient(name);
        
        if (response.status == ResponseStatus.FAIL)
        {
            System.out.println("  " + response.message);
        }
    }
    
    private Client getClient()
    {
        System.out.print("  Scuba id: ");
        String id = In.nextLine();
        
        if (id.equals("x")) return null;
        
        Client client = repository.findClientById(id);
        if (client == null) {
            System.out.println("  No such client");
            getClient();
        }
        
        return client;
    }
    
    private void makeBooking()
    {
        System.out.print("Boat: ");
        int index = In.nextInt();
        
        Boat boat = repository.findBoatByIndex(index);
        if (boat == null) {
            System.out.println("  No such boat");
            return;
        }
        
        if (boat.spotsLeft() < 1) {
            System.out.println("  Boat is full");
            return;
        }
        

        System.out.println("  Stops 0-" + boat.stops());
        Client client = getClient();
        
        while (client != null)
        {
            if (client == null) return;
        
            if (client.balance() <= 0) {
                System.out.println("  No money");
                client = getClient();
                continue;
            }
            
            System.out.print("    Trip: ");
            String rawBooking = In.nextLine();
            
            int start   = Integer.parseInt( rawBooking.split(" ")[0] );
            int end     = Integer.parseInt( rawBooking.split(" ")[1] );
            
            Trip trip = new Trip(client, start, end);
            boat.addTrip(trip);
            
            client = getClient();
        }
        
    }
    
    private void runBoats()
    {
        LinkedList<RouteResponse> result = environment.run();
        
        // iterate through the results and 
        // format nicely for the console
        for (RouteResponse route: result) {
            if (route.stopsCount() == 0) continue;
            
            System.out.println(route.boat.toString());
            
            for (RouteStop stop: route.stops) {
                System.out.println("  Stop " + stop.index());
                System.out.println("    " + stop.toString());
            }
        }
        
        repository.resetBoats();
    }
}
