package uiTest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class HomePage {

    WebDriver driver;

    By menuSignUp = By.id("signin2");
    By menuLogin = By.id("login2");
    By menuContact = By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a");
    By menuAboutUs = By.xpath("//*[@id=\"navbarExample\"]/ul/li[3]/a");
    By formSignUp = By.xpath("//*[@id=\"signInModalLabel\"]");
    By formLogin = By.xpath("//*[@id=\"logInModalLabel\"]");
    By formContact = By.id("exampleModalLabel");
    By formAboutUs = By.id("videoModalLabel");
    By buttonClose = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]");
    By buttonClose2 = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]");
    By buttonClose3 = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]");
    By buttonClose4 = By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button");
    By boxUsername = By.id("sign-username");
    By boxPassword = By.id("sign-password");
    By signUpButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    By logInButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    By sendMessageButton = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]");
    By boxLoginUsername = By.id("loginusername");
    By boxLoginPassword = By.id("loginpassword");
    By boxContact = By.id("recipient-email");
    By boxName = By.id("recipient-name");
    By boxMessage = By.id("message-text");
    By headerCategory = By.id("cat");
    By buttonCart = By.id("cartur");
    By playButton = By.xpath("//*[@id=\"example-video\"]/button/span[1]");
    By categoryProducts = By.cssSelector("a[href^='prod.html?idp_=']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void userIsOnHomePage(){
        WebElement homeTitle = driver.findElement(headerCategory);
        assertTrue(homeTitle.isDisplayed());
        assertEquals("CATEGORIES", homeTitle.getText());
    }

//    Home Page

    public void userClicksArrowOnCarousel(String arrowDirection) {
        By arrowLocator;
        if (arrowDirection.equalsIgnoreCase("next")) {
            arrowLocator = By.cssSelector(".carousel-control-next");
        } else if (arrowDirection.equalsIgnoreCase("previous")) {
            arrowLocator = By.cssSelector(".carousel-control-prev");
        } else {
            throw new IllegalArgumentException("Invalid arrow direction: " + arrowDirection);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement arrowButton = wait.until(ExpectedConditions.elementToBeClickable(arrowLocator));
        arrowButton.click();
    }

    public void carouselSlides() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement activeSlideBefore = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".carousel-item.active")));
        String slideBeforeId = activeSlideBefore.getAttribute("class");

        WebElement nextArrow = driver.findElement(By.cssSelector(".carousel-control-next"));
        nextArrow.click();

        wait.until(driver -> {
            WebElement activeSlideAfter = driver.findElement(By.cssSelector(".carousel-item.active"));
            String slideAfterId = activeSlideAfter.getAttribute("class");
            return !slideBeforeId.equals(slideAfterId);
        });

        WebElement activeSlideAfter = driver.findElement(By.cssSelector(".carousel-item.active"));
        String slideAfterId = activeSlideAfter.getAttribute("class");

        assertNotEquals("Carousel did not slide to a new item. Actual: " + slideAfterId, slideBeforeId, slideAfterId);
    }

    public void userClicksOnCategories(String cat){
        WebElement categoryElement = driver.findElement(By.xpath("//a[@id='itemc' and text()='" + cat + "']"));
        categoryElement.click();
    }

    public void pageDisplayOnlyProductsUnderCategory(String category) {
        List<String> expectedProductIds;
        switch (category) {
            case "Phones":
                expectedProductIds = List.of("1", "2", "3", "4", "5", "6", "7");
                break;
            case "Laptops":
                expectedProductIds = List.of("8", "9", "11", "12", "13", "15");
                break;
            case "Monitors":
                expectedProductIds = List.of("10", "14");
                break;
            default:
                throw new IllegalArgumentException("invalid category:" + category);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[href^='prod.html?idp_=']")));
        List<WebElement> displayedProducts = driver.findElements(By.cssSelector("a[href^='prod.html?idp_=']"));

        Set<String> uniqueProductIds = new HashSet<>();
        for (WebElement product : displayedProducts) {
            String productHref = product.getAttribute("href");
            String productId = productHref.substring(productHref.indexOf("idp_=") + 5);
            uniqueProductIds.add(productId);
        }

        assertEquals(expectedProductIds.size(), uniqueProductIds.size());
        for (String productId : uniqueProductIds) {
            assertTrue(expectedProductIds.contains(productId));
        }

    }

    public void userClicksCategoryHeader(){
        driver.findElement(headerCategory).click();
    }

    public void allCategoryProductsAreDisplayed() {
        List<String> allExpectedProductIds = List.of("1", "2", "3", "4", "5", "6", "7", // Phones
                "8", "9"
//                "11", "12", "13", "15", // Laptops
//                "10", "14"
        ); // Monitors

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[href^='prod.html?idp_=']")));

        List<WebElement> displayedProducts = driver.findElements(By.cssSelector("a[href^='prod.html?idp_=']"));

        Set<String> uniqueProductIds = new HashSet<>();
        for (WebElement product : displayedProducts) {
            String productHref = product.getAttribute("href");
            String productId = productHref.substring(productHref.indexOf("idp_=") + 5);
            uniqueProductIds.add(productId);
        }

        assertEquals(allExpectedProductIds.size(), uniqueProductIds.size());
        for (String productId : allExpectedProductIds) {
            assertTrue(uniqueProductIds.contains(productId));
        }
    }

    public void userClicksPaginationButton(String buttonType) {
        WebElement button;
        if (buttonType.equalsIgnoreCase("Next")) {
            button = driver.findElement(By.id("next2"));
        } else if (buttonType.equalsIgnoreCase("Previous")) {
            button = driver.findElement(By.id("prev2"));
        } else {
            throw new IllegalArgumentException("Invalid button type: " + buttonType);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }

    public void pageDisplaysNextSetOfProducts() {
        List<WebElement> productsBeforeClick = driver.findElements(By.cssSelector(".product-class-selector"));

        userClicksPaginationButton("Next");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElements(By.cssSelector(".product-class-selector")).size() > productsBeforeClick.size());

        List<WebElement> productsAfterClick = driver.findElements(By.cssSelector(".product-class-selector"));
        assertTrue("Next set of products not displayed correctly", productsAfterClick.size() > productsBeforeClick.size());
    }

    public void waitForPaginationButtonToAppear(String buttonType) {
        WebElement button;
        if (buttonType.equalsIgnoreCase("Next")) {
            button = driver.findElement(By.id("next2"));
        } else if (buttonType.equalsIgnoreCase("Previous")) {
            button = driver.findElement(By.id("prev2"));
        } else {
            throw new IllegalArgumentException("Invalid button type: " + buttonType);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            if (buttonType.equalsIgnoreCase("Next")) {
                wait.until(ExpectedConditions.visibilityOf(button));
            } else {
                wait.until(ExpectedConditions.visibilityOf(button));
            }
        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for " + buttonType + " button.");
            throw e;
        }
    }

    public void userClicksOnTheTitle(String product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productTitle = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h4/a[text()='" + product + "']")
        ));
        productTitle.click();
    }

//    Sign Up Feature

    public void userClicksMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signUpMenu = wait.until(ExpectedConditions.elementToBeClickable(menuSignUp));
        signUpMenu.click();
    }

    public void signUpFormIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement formSignUpLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(formSignUp));

        assertTrue(formSignUpLabel.isDisplayed());
        assertEquals("Sign up", formSignUpLabel.getText());
    }

    public void userIsOnSignUpForm(){
        userIsOnHomePage();
        userClicksMenu();
        signUpFormIsDisplayed();
    }

    public void userClicksCloseButton(){
        driver.findElement(buttonClose).click();
    }

    public void signUpFormIsClosed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(formSignUp));
            assertTrue("Sign Up form is still visible.", true);
        } catch (Exception e) {
            assertTrue("Sign Up form is still visible.", false);
        }
    }

    public void setBoxUsername(String username){
        driver.findElement(boxUsername).sendKeys(username);
    }

    public void setBoxPassword(String password){
        driver.findElement(boxPassword).sendKeys(password);
    }

    public void userClicksSignUpButton(){
        driver.findElement(signUpButton).click();
    }

    public void popUpAppearsWithTheMessage(String popUpMessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();

        assertEquals("Pop-up message is not as expected", popUpMessage, actualMessage);
        alert.accept();

    }

//    Login Feature

    public void userClicksLogInMenu(){
        driver.findElement(menuLogin).click();
    }

    public void logInFormIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement formLogInLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(formLogin));

        assertTrue(formLogInLabel.isDisplayed());
        assertEquals("Log in", formLogInLabel.getText());
    }

    public void userIsOnLogInForm(){
        userIsOnHomePage();
        userClicksLogInMenu();
        logInFormIsDisplayed();
    }

    public void userClicksLogInCloseButton(){
        driver.findElement(buttonClose2).click();
    }

    public void logInFormIsClosed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(formLogin));
            assertTrue("Log In form is still visible.", true);
        } catch (Exception e) {
            assertTrue("Log In form is still visible.", false);
        }
    }

    public void userLoginWithUsername(String usn){
        driver.findElement(boxLoginUsername).sendKeys(usn);
    }

    public void userLoginWithPassword(String pass){
        driver.findElement(boxLoginPassword).sendKeys(pass);
    }

    public void userClicksLogInButton(){
        driver.findElement(logInButton).click();
    }

//    Contact Message

    public void userClicksNewMessageMenu(){
        driver.findElement(menuContact).click();
    }

    public void newMessageFormIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement formContactLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(formContact));

        assertTrue(formContactLabel.isDisplayed());
        assertEquals("New message", formContactLabel.getText());
    }

    public void userIsOnNewMessageForm(){
        userIsOnHomePage();
        userClicksNewMessageMenu();
        newMessageFormIsDisplayed();
    }

    public void userClicksNewMessageCloseButton(){
        driver.findElement(buttonClose3).click();
    }

    public void newMessageFormIsClosed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(formContact));
            assertTrue("Contact form is still visible.", true);
        } catch (Exception e) {
            assertTrue("Contact form is still visible.", false);
        }
    }

    public void userInputContactEmailWith(String e_mail) {
        driver.findElement(boxContact).sendKeys(e_mail);
    }

    public void userInputContactNameWith(String name) {
        driver.findElement(boxName).sendKeys(name);
    }

    public void userInputMessageWith(String message) {
        driver.findElement(boxMessage).sendKeys(message);
    }

    public void userClicksSendMessageButton() {
        driver.findElement(sendMessageButton).click();
    }

//    About Us Content

    public void userClicksAboutUs() {
        driver.findElement(menuAboutUs).click();
    }

    public void aboutUsContentIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement formAboutUsLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(formAboutUs));

        assertTrue(formAboutUsLabel.isDisplayed());
        assertEquals("About us", formAboutUsLabel.getText());
    }

    public void userIsOnAboutUsContent() {
        userIsOnHomePage();
        userClicksAboutUs();
        aboutUsContentIsDisplayed();
    }

    public void userClicksAboutUsCloseButton() {
        driver.findElement(buttonClose4).click();
    }

    public void aboutUsContentIsClosed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(formAboutUs));
            assertTrue("About Us content is still visible.", true);
        } catch (Exception e) {
            assertTrue("About Us content is still visible.", false);
        }
    }

    public void userClicksPlayButton() {
        driver.findElement(playButton).click();
    }

    public void contentStartToPlay() {
    }


    public void userClicksCartOnNavbar(){
        driver.findElement(buttonCart).click();
    }
}