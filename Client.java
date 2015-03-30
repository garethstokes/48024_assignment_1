import java.io.*;

public class Client extends Person implements Serializable
{
   private String id;
   private double balance;
   
   private static int counter = 1;
   
   public Client(String name) {
       this.id = "10" + (counter);
       setName(name);
       balance = 100;
       
       counter += 1;
   }
   
   public String id()
   {
       return this.id;
   }
    
   public double balance()
   {
       return this.balance;
   }
   
   public String toString()
   {
       return "Scuba" + id;
   }
   
   public void charge(double amount)
   {
       this.balance -= amount;
   }
}
