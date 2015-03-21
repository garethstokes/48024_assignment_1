public class TestRunner
{
    public static void run() {
        // Client
        ClientTests client = new ClientTests();
        client.ShouldCreateCorrectId();
        
        // Driver
        DriverTests driver = new DriverTests();
        driver.ShouldCreateCorrectId();
        
        // Boat
        BoatTests boat = new BoatTests();
        boat.ShouldConstructBoat();
        
        // Repository
        RepositoryTests repo = new RepositoryTests();
        
        repo.ShouldFindAllClients();
        repo.ShouldFindClientById();
        
        repo.ShouldFindAllBoats();
        repo.ShouldFindBoatByIndex();
    }
}
