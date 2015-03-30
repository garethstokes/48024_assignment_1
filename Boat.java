import java.util.LinkedList; 

public class Boat
{
    public int stops;
    public Driver driver;
    public int capacity = 2;
    public LinkedList<Trip> trips;
    
    public Boat(Driver d, int s) {
        stops = s -1;
        driver = d;
        
        trips = new LinkedList<Trip>();
    }
    
    public int spotsLeft() 
    {
        return capacity;
    }
    
    public void addTrip(Trip trip) {
        trips.add(trip);
    }
    
    public String toString() {
        return driver.id + " with " + driver.name;
    }
    
    public int stops()
    {
        return this.stops;
    }
}
