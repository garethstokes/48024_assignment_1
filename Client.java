public class Client extends Person
{
   public String id;
   public double balance;
   
   public Client(int index, String n) {
       id = "Scuba10" + (index + 1);
       name = n;
       balance = 100;
   }
}
