package uiTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/UiCucumber.html", "json:reports/UiCucumber"},
        glue = {"uiTest/stepDef"},
        features = {"src/test/resources/featuresUi"},
        tags = "@web",
        monochrome = true
)
public class CucumberUITest {
}
