public class Trip
{
    public Client client;
    private int start;
    private int end;
    public boolean isCharged = false;
    
    public Trip(Client client, int s, int e)
    {
        this.client = client;
        start = s;
        end = e;
    }
    
    public int start() { return this.start; }
    public int end() { return this.end; }
}
