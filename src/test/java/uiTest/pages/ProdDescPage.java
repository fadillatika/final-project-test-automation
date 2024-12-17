package uiTest.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProdDescPage {

    WebDriver driver;

    By nameProd = By.className("name");
    By addToCartButton = By.cssSelector(".btn.btn-success.btn-lg");
    By brandLogo = By.id("nava");
    By buttonCart = By.id("cartur");
    By productCart = By.xpath("//*[@id=\"page-wrapper\"]/div/div[1]/h2");
    By placeOrderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");

    public ProdDescPage (WebDriver driver){
        this.driver = driver;
    }

    public void chooseProduct(String product) {
        try {
            if (driver.getTitle().isEmpty()) {
                throw new IllegalStateException("The website is down or not loaded properly.");
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement productTitle = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//h4/a[text()='" + product + "']")
            ));
            productTitle.click();

        } catch (IllegalStateException e) {
            System.err.println("Website issue: " + e.getMessage());
        } catch (TimeoutException e) {
            System.err.println("Timeout: Element not clickable within 10 seconds for product: " + product);
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void goToProdDescPage(String prodTitle){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameProd));

        assertTrue(productElement.isDisplayed());
        assertEquals(prodTitle, productElement.getText());
    }

    public void userIsOnDescriptionProduct (String productDescript){
        chooseProduct(productDescript);
        goToProdDescPage(productDescript);
    }

    public void userClicksAddToCartButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartBtn.click();
    }

    public void popUpAppears(String popUpMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();

        assertEquals("Pop-up message is not as expected", popUpMessage, actualMessage);
        alert.accept();
    }

    public void handlePopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void userClicksOnTheBrand(){
        driver.findElement(brandLogo).click();
    }

    public void userHasAddedProductsToCart(DataTable productsTable) {
        List<String> products = productsTable.asList();

        for (String product : products) {
            chooseProduct(product);
            userClicksAddToCartButton();
            handlePopUp();
            userClicksOnTheBrand();
        }
    }

    public void userSuccessPlacingOrders(DataTable productsName) {
        List<String> products = productsName.asList();

        for (String product : products) {
            chooseProduct(product);
            userClicksAddToCartButton();
            handlePopUp();
            userClicksOnTheBrand();
        }

        driver.findElement(buttonCart).click();
        driver.findElement(productCart);
        driver.findElement(placeOrderButton).click();
    }

}
