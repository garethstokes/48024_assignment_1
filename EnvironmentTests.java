import java.util.LinkedList;

public class EnvironmentTests extends TestBase
{
    public EnvironmentTests() { namespace = "Environment"; }
    
    public void ShouldRunEnvironment()
    {
        // Arrange.
        Repository repository = new Repository();
        repository.seed();
        Environment environment = new Environment(repository);
        
        // Act.
        LinkedList<RouteResponse> result = environment.run();
        
        // Assert.
        AssertNotNull(result, "RouteResponse was null");
    }
}
