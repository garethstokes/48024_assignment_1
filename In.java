import java.util.*;

public class In
{   public static Scanner in = new Scanner(System.in);
    
    public static String nextLine()
    {   return in.nextLine(); }
    
    public static char nextChar()
    {   return in.nextLine().charAt(0); }
    
    public static int nextInt()
    {   int i = 0;
        try
        {   i = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e)
        {   i = nextInt();  }
        return i;   }

    public static double nextDouble()
    {   double d = 0.00;
        try
        {   d = Double.parseDouble(in.nextLine());
        } catch(NumberFormatException e)
        {   d = nextDouble();  }
        return d;   }
}
