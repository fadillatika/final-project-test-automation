package uiTest.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CartPage {

    WebDriver driver;

    By buttonCart = By.id("cartur");
    By productCart = By.xpath("//*[@id=\"page-wrapper\"]/div/div[1]/h2");
    By brandLogo = By.id("nava");
    By itemList = By.xpath("//*[@id='tbodyid']/tr/td[2]");
    By deleteButton = By.xpath(".//a[contains(@onclick, 'deleteItem')]");
    By placeOrderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    By placeOrderForm = By.id("orderModalLabel");
    By formName = By.id("name");
    By formCountry = By.id("country");
    By formCity = By.id("city");
    By formCard = By.id("card");
    By formMonth = By.id("month");
    By formYear = By.id("year");
    By purchaseButton = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    By closePurchaseButton = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]");
    By purchaseSuccess =  By.xpath("/html/body/div[10]/h2");
    By okPurchaseSuccess = By.xpath("/html/body/div[10]/div[7]/div/button");
    By totalPrice = By.id("totalp");
    By totalPriceM = By.id("totalm");
    By rowtbodytr = By.xpath("//*[@id='tbodyid']/tr");
    By totalPriceF = By.xpath("//div[contains(@class, 'lead')]/p[contains(text(), 'Amount')]");

    public CartPage (WebDriver driver){
        this.driver = driver;
    }

    public void userClicksCartNavbar(){
        driver.findElement(buttonCart).click();
    }

    public void goToCartPage(){
        WebElement cartTitle = driver.findElement(productCart);
        assertTrue(cartTitle.isDisplayed());
        assertEquals("Products", cartTitle.getText());
    }

    public void userIsOnCartPage(){
        userClicksCartNavbar();
        goToCartPage();
    }

    public void userClicksOnTheBrandLogo(){
        driver.findElement(brandLogo).click();
    }

    public void ensureTheProductAppearsInTheCart(List<String> expectedItem) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemList));

        List<WebElement> cartItem = driver.findElements(itemList);

        List<String> actualItem = cartItem.stream()
                .map(e -> e.getText().trim().toLowerCase())
                .collect(Collectors.toList());

        for (String expectedItems : expectedItem) {
            assertTrue("Expected item: " + expectedItems + " was not found in the cart.",
                    actualItem.contains(expectedItems.trim().toLowerCase()));
        }
    }

    public void ensureProductPriceMatches(Map<String, Integer> expectedPrices) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/tr")));

        List<WebElement> cartRows = driver.findElements(By.xpath("//*[@id='tbodyid']/tr"));

        for (WebElement row : cartRows) {
            String productName = row.findElement(By.xpath(".//td[2]")).getText().trim();
            int actualPrice = Integer.parseInt(row.findElement(By.xpath(".//td[3]")).getText().trim());

            assertTrue("Product not found in expected prices: " + productName, expectedPrices.containsKey(productName));
            assertEquals("Price mismatch for product: " + productName, (int) expectedPrices.get(productName), actualPrice);
        }
    }

    public void ensureProductCountMatches(List<String> expectedProducts) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/tr")));

        List<WebElement> cartRows = driver.findElements(By.xpath("//*[@id='tbodyid']/tr"));

        List<String> actualProducts = new ArrayList<>();

        for (WebElement row : cartRows) {
            String productName = row.findElement(By.xpath(".//td[2]")).getText().trim();
            actualProducts.add(productName);
        }

        assertEquals("Product count mismatch in the cart", expectedProducts.size(), cartRows.size());

        for (String expectedProduct : expectedProducts) {
            assertTrue("Product " + expectedProduct + " not found in the cart", actualProducts.contains(expectedProduct));
        }
    }

    public void totalPriceIsCorrect(Map<String, Integer> expectedPrices){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(rowtbodytr));

        List<WebElement> cartRows = driver.findElements(rowtbodytr);

        int calculatedTotalPrice = 0;
        for (WebElement row : cartRows) {
            String productName = row.findElement(By.xpath(".//td[2]")).getText().trim();
            int productPrice = Integer.parseInt(row.findElement(By.xpath(".//td[3]")).getText().trim());

            assertTrue("Price mismatch for product: " + productName,
                    expectedPrices.containsKey(productName));
            int expectedPrice = expectedPrices.get(productName);
            assertEquals("Price mismatch for " + productName, expectedPrice, productPrice);

            calculatedTotalPrice += productPrice;
        }

        int displayedTotalPrice = Integer.parseInt(driver.findElement(totalPrice).getText().trim());

        assertEquals("Total price mismatch. Expected: " + calculatedTotalPrice + ", but found: " + displayedTotalPrice,
                calculatedTotalPrice, displayedTotalPrice);
    }

    public void userClicksDeleteButton(String delProd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productList = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[normalize-space(text())='" + delProd + "']/..")
        ));
        WebElement delButton = productList.findElement(deleteButton);
        delButton.click();
    }

    public void productDeleted(String deleted) {
        WebElement productList = driver.findElement(By.xpath("//td[text()='" + deleted + "']/.."));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(productList));

        List<WebElement> remainingProducts = driver.findElements(By.xpath("//td[text()='" + deleted + "']"));
        assertTrue("Product was not successfully deleted from the cart.", remainingProducts.isEmpty());

    }

    public void userClicksPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
    }

    public void formOfDataToFillInAppears() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement formData = wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderForm));

        assertTrue(formData.isDisplayed());
        assertEquals("Place order", formData.getText());
    }

    public void totalPriceInFormIsCorrect() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement totalPriceForm = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceM));
        WebElement totalPriceCart = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));

        assertTrue(totalPriceCart.isDisplayed());
        assertTrue(totalPriceForm.isDisplayed());

        String totalPriceCartText = totalPriceCart.getText().trim();
        String totalPriceFormText = totalPriceForm.getText().trim();

        if (totalPriceCartText.startsWith("Total: ")) {
            totalPriceCartText = totalPriceCartText.substring("Total: ".length()).trim();
        }
        if (totalPriceFormText.startsWith("Total: ")) {
            totalPriceFormText = totalPriceFormText.substring("Total: ".length()).trim();
        }

        assertNotNull("Total price in cart is not displayed", totalPriceCartText);
        assertNotNull("Total price in form is not displayed", totalPriceFormText);

        assertEquals("Total price mismatch. Expected: " + totalPriceFormText + ", but found: " + totalPriceCartText,
                totalPriceFormText, totalPriceCartText);
    }

    public void userInputNameWith(String name) {
        driver.findElement(formName).sendKeys(name);
    }

    public void userInputCountryWith(String country) {
        driver.findElement(formCountry).sendKeys(country);
    }

    public void userInputCityWith(String city) {
        driver.findElement(formCity).sendKeys(city);
    }

    public void userInputCreditCardWith(String card) {
        driver.findElement(formCard).sendKeys(card);
    }

    public void userInputMonthWith(String month) {
        driver.findElement(formMonth).sendKeys(month);
    }

    public void userInputYearWith(String year) {
        driver.findElement(formYear).sendKeys(year);
    }

    public void userClicksPurchaseButton() {
        driver.findElement(purchaseButton).click();
    }

    public void userSuccessfullyPurchasesProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successPurchaseAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(purchaseSuccess));

        assertTrue(successPurchaseAlert.isDisplayed());
        assertEquals("Thank you for your purchase!", successPurchaseAlert.getText());

        driver.findElement(okPurchaseSuccess).click();
    }

    public void popUpOnCartAppears(String popUpMessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();

        assertEquals("Pop-up message is not as expected", popUpMessage, actualMessage);
        alert.accept();
    }
}
