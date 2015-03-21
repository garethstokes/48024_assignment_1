public class DriverTests extends TestBase
{
   public DriverTests() { namespace = "Driver"; }
    
   public void ShouldCreateCorrectId() {
        Driver driver = new Driver(0, "Britta");
        
        Assert(driver.id, "Scuba1", "id");
        Assert(driver.name, "Britta", "name");
   }
}
