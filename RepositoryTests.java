import java.util.LinkedList;

public class RepositoryTests extends TestBase
{
   public RepositoryTests() { namespace = "Repository"; }
    
   public void ShouldFindAllClients() {
       // Arrange. 
       Repository repo = new Repository();
       repo.createClient("Jeff Winger");
       repo.createClient("Troy Barnes");
       repo.createClient("Britta Parry");
       
       // Act.
       LinkedList<Client> clients = repo.allClients();
        
       // Assert
       AssertTrue(clients.size() == 3, "Number of clients returned");
   }
   
   public void ShouldFindClientById() {
       // Arrange. 
       Repository repo = new Repository();
       Client jeff = repo.createClient("Jeff Winger");
       
       // Act.
       Client result = repo.findClientById("Scuba101");
        
       // Assert
       AssertNotNull(result, "should find client by id");
   }
   
   public void ShouldFindAllBoats() {
       // Arrange. 
       Repository repo = new Repository();
       repo.seed();
       
       // Act.
       LinkedList<Boat> boats = repo.allBoats();
        
       // Assert
       AssertTrue(boats.size() == 3, "Number of boats returned");
   }
   
   public void ShouldFindBoatByIndex() {
       // Arrange. 
       Repository repo = new Repository();
       repo.seed();
       
       // Act.
       Boat boat = repo.findBoatByIndex(1);
        
       // Assert
       AssertNotNull(boat, " Should find boat by index");
       //AssertNotNull(boat.driver, " driver is null");
   }
}
