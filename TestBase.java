public abstract class TestBase
{
    static String tab = "  ";
    String namespace = "";
    
    public void Assert(String a, String b, String description) {
        if (a.equals(b) == false) {
            System.out.println("FAIL: " + namespace + "." + description);
            System.out.println(tab + "Expected: " + b + ", but found: " + a);
            return;
        }
        
        System.out.println("SUCCESS: " + namespace + "." + description);
    }
    
    public void Assert(int a, int b, String description) {
        if (a != b) {
            System.out.println("FAIL: " + namespace + "." + description);
            System.out.println(tab + "Expected: " + b + ", but found: " + a);
            return;
        }
        
        System.out.println("SUCCESS: " + namespace + "." + description);
    }
    
    public void AssertTrue(boolean result, String message)
    {
        String status = (result) ? "SUCCESS: " : "FAIL: ";
        System.out.println(status + namespace + ", " + message);  
    }
    
    public void AssertNotNull(Object obj, String message) {
        String status = (obj != null) ? "SUCCESS: " : "FAIL: ";
        System.out.println(status + namespace + ", " + message);  
    }
}
