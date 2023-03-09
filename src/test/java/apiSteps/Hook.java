package apiSteps;

import adapters.Specification;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static utils.Endpoints.GITHUB;

public class Hook {
    @Before
    public void setUp() {
        System.out.println("Api start");
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
    }

    @After
    public void tearDown() {
        System.out.println("api end");
    }
}
