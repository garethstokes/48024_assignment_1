import java.util.LinkedList;
import java.text.*;

public class Main
{
    private Repository repository;
    private Environment environment;
    
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        repository  = new Repository();
        environment = new Environment(repository);

        // remove this later
        repository.seed();
        
        menu();
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
            System.out.println(client.name + " (" + client.id + ") has $" + formatted(client.balance));
        }
    }
    
    private String formatted(double amount)
    {   
        DecimalFormat twoD = new DecimalFormat("###,##0.00");
        return twoD.format(amount);  
    }
    
    private void addClient() 
    {
        System.out.print("Name: ");
        String name = In.nextLine();
        
        Client client = repository.createClient(name);
        System.out.println("  Hi " + client.name + ", you are " + client.id);
    }
    
    private void removeClient() {
        System.out.print("Name: ");
        String name = In.nextLine();
        
        StandardResponse response = repository.deleteClient(name);
        
        if (response.status == ResponseStatus.FAIL)
        {
            System.out.println(response.message);
        }
    }
    
    private void makeBooking()
    {
        System.out.print("Boat: ");
        int index = In.nextInt();
        
        Boat boat = repository.findBoatByIndex(index);
        if (boat == null) {
            System.out.println("No such boat");
            return;
        }
        
        if (boat.spotsLeft() < 1) {
            System.out.println("Boat is full");
            return;
        }
        
        System.out.print("  Scuba id: ");
        
        Client client = repository.findClientById(In.nextLine());
        if (client == null) {
            System.out.println("No such client");
            return;
        }
        
        if (client.balance <= 0) {
            System.out.println("The client has no or negative money");
            return;
        }
        
        System.out.print("    Trip: ");
        int start   = In.nextInt();
        int end     = In.nextInt();
        
        Trip trip = new Trip(client, start, end);
        boat.addTrip(trip);
    }
    
    private void runBoats()
    {
        environment.run();
        
        // iterate through the results and 
        // format nicely for the console
    }
}