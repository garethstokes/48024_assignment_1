import java.util.LinkedList;
import java.text.*;

public class Root
{
    private Repository repository;
    private Environment environment;
    
    public static void main(String[] args) {
        new Root();
    }
    
    public Root() {
        repository  = new Repository();
        environment = new Environment(repository);

        // remove this later
        repository.seed();
        
        char c = choice();
        
        while (c != 'x') {
            if (c == 'f') {
                // store and exit
                System.out.println("store and exit");
                repository.persist();
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
            System.out.println("  " + client.name + " (" + client.toString() + ") has $" + formatted(client.balance()));
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
        System.out.println("    Hi " + client.name + ", you are " + client.toString());
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
        System.out.print("  Scuba id: ");
        
        Client client = repository.findClientByNameAndId(In.nextLine());
        if (client == null) {
            System.out.println("  No such client");
            return;
        }
        
        if (client.balance() <= 0) {
            System.out.println("  The client has no or negative money");
            return;
        }
        
        System.out.print("    Trip: ");
        String rawBooking = In.nextLine();
        
        int start   = Integer.parseInt( rawBooking.split(" ")[0] );
        int end     = Integer.parseInt( rawBooking.split(" ")[1] );
        
        Trip trip = new Trip(client, start, end);
        boat.addTrip(trip);
    }
    
    private void runBoats()
    {
        LinkedList<RouteResponse> result = environment.run();
        
        // iterate through the results and 
        // format nicely for the console
        for (RouteResponse route: result) {
            System.out.print(route.boat.toString());
            
            for (RouteStop stop: route.stops) {
                System.out.print("  " + stop.toString());
            }
        }
    }
}
