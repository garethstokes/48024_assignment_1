import java.io.*;

public class Store
{
    private Repository repository; 
    private String fileName = "repository.dat";
    
    public Store()
    {
        this.repository = new Repository();
        this.repository.seed();
    }
    
    public Repository repository()
    {
        return this.repository;
    }

    /*
     * Load models from disk
     */
    public Repository read() {
        ObjectInputStream in = null;
        Repository repo = null;
        
        try
        {
            FileInputStream stream = new FileInputStream(fileName);
            in = new ObjectInputStream(stream);
            repo = (Repository)in.readObject();
            System.out.println("  Read from file");
        }
        catch(FileNotFoundException e)
        {
            repo = this.repository();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e.toString());
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
        }
        finally
        {
            try
            {
                if (in != null) in.close();
            }
            catch(IOException e)
            {
                System.out.println(e.toString());
            }
            finally
            {
                return repo;
            }
        }
    }
    
    /*
     * Save models to disk
     */
    public boolean persist() throws IOException {
        ObjectOutputStream out = null;
        
        try
        {
            FileOutputStream stream = new FileOutputStream(fileName);
            out = new ObjectOutputStream(stream);
            out.writeObject(repository);
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
        }
        finally
        {
            if (out != null) out.close();
        }
        
        return true;
    }
}
