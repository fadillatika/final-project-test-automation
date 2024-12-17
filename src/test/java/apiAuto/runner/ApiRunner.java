package apiAuto.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/ApiCucumber.html", "json:reports/ApiCucumber"},
        glue = {"apiAuto/stepDef"},
        features = {"src/test/resources/featuresApi"},
        tags = "@api",
        monochrome = true
)
public class ApiRunner {
}
