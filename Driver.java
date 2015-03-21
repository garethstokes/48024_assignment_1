public class Driver extends Person
{
    public String id;
    
    public Driver(int index, String n) {
        id = "Scuba" + (index +1);
        name = n;
    }
}
