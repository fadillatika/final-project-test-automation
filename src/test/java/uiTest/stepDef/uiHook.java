package uiTest.stepDef;


import uiTest.baseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
public class uiHook extends baseTest {
    @Before
    public void beforeTest(){
        getDriver();

        driver.get("https://www.demoblaze.com/");

    }

    @After
    public void afterTest(){
        driver.close();
    }
}
