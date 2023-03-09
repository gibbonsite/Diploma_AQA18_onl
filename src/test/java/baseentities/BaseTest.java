package baseentities;

import com.google.common.collect.ImmutableMap;
import core.configuration.ReadProperties;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;

import java.nio.file.Paths;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class BaseTest extends AbstractTestNGCucumberTests {
    @AfterSuite
    public void writeAllureEnvironment() {
        String resultsDirectory = Paths.get(System.getProperty("user.dir"),
                ReadProperties.getAllureConfig().resultsDirectory().replace("/", "\\")) + "\\";
        allureEnvironmentWriter(ImmutableMap.<String, String>builder()
                .put("Browser", ReadProperties.getUiConfig().browser())
                .put("OS", System.getProperty("os.name"))
                .put("OS.Architecture", System.getProperty("os.arch"))
                .build(),
                resultsDirectory);
    }
}
