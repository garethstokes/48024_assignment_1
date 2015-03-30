import java.io.*;

public abstract class Person implements Serializable
{
    private String name;
    
    public String name()
    {
        return this.name;
    }
    
    public void setName(String str)
    {
        this.name = str;
    }
}
