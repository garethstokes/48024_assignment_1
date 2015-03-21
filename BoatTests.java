public class BoatTests extends TestBase
{
    public BoatTests() { namespace = "Boat"; }
    
    public void ShouldConstructBoat() {
        Boat boat = new Boat(new Driver(0, "Shirley"), 3);
        
        Assert(boat.driver.name, "Shirley", "name");
        Assert(boat.stops, 3, "stops");
    }
}
