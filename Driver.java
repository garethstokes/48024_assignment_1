import java.io.*;

public class Driver extends Person implements Serializable
{
    public String id;
    
    public Driver(int index, String n) {
        id = "Scuba" + (index +1);
        setName(n);
    }
}
