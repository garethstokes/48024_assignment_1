import java.util.LinkedList; 
import java.io.*;

public class Boat implements Serializable
{
    private int stops;
    private Driver driver;
    private int capacity = 2;
    private LinkedList<Trip> trips;
    
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
        return driver.id + " with " + driver.name();
    }
    
    public int stops()
    {
        return this.stops;
    }
    
    public LinkedList<Trip> trips()
    {
        return this.trips;
    }
    
    public void reset()
    {
        this.trips = new LinkedList<Trip>();
    }
}
