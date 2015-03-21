public class StandardResponse
{
    public ResponseStatus status = ResponseStatus.FAIL;
    public String message = "";
    
    public StandardResponse(ResponseStatus s, String m) {
        status = s;
        message = m;
    }
    
    public static StandardResponse OK() {
        return new StandardResponse(ResponseStatus.OK, "");
    }
    
    public static StandardResponse OK(String message) {
        return new StandardResponse(ResponseStatus.OK, message);
    }
    
    public static StandardResponse Fail(String message) {
        return new StandardResponse(ResponseStatus.FAIL, message);
    }
}
