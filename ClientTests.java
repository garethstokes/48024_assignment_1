public class ClientTests extends TestBase
{
   public ClientTests() { namespace = "Client"; }
    
    public void ShouldCreateCorrectId() {
        Client client = new Client(0, "Abed");
        
        Assert(client.id, "Scuba101", "id");
        Assert(client.name, "Abed", "name");
   }
}
