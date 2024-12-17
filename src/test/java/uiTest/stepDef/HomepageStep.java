package uiTest.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import uiTest.baseTest;
import uiTest.pages.HomePage;
import uiTest.helper.Utillity;

public class HomepageStep extends baseTest {

    protected HomePage homePage;

    @Given("user is on home page")
    public void userIsOnHomePage() {
        homePage = new HomePage(driver);
        homePage.userIsOnHomePage();

    }

//    Sign Up Step

    @When("user clicks Sign Up menu")
    public void userClicksSignUpMenu() {
        homePage.userClicksMenu();
    }

    @Then("Sign Up form is displayed")
    public void signUpFormIsDisplayed() {
        homePage.signUpFormIsDisplayed();
    }

    @Given("user is on Sign Up form")
    public void userIsOnSignUpForm() {
        homePage = new HomePage(driver);
        homePage.userIsOnSignUpForm();
    }

    @When("user clicks Close button")
    public void userClicksCloseButton() {
        homePage.userClicksCloseButton();
    }

    @Then("Sign Up form is closed")
    public void signUpFormIsClosed() {
        homePage.signUpFormIsClosed();
    }

    @When("user input username")
    public void userInputUsername() {
        String randomUsername = Utillity.generateRandomUsername();
        homePage.setBoxUsername(randomUsername);
    }

    @And("user input password")
    public void userInputPassword() {
        String randomPassword = Utillity.generateRandomPassword();
        homePage.setBoxPassword(randomPassword);
    }

    @When("user input username with {string}")
    public void userInputUsernameWith(String username) {
        homePage.setBoxUsername(username);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        homePage.setBoxPassword(password);
    }

    @And("user clicks Sign Up button")
    public void userClicksSignUpButton() {
        homePage.userClicksSignUpButton();
    }

    @Then("pop-up appears with the message {string}")
    public void popUpAppearsWithTheMessage(String popUpMessage) {
        homePage.popUpAppearsWithTheMessage(popUpMessage);
    }

//    Log In Step

    @When("user clicks Log in menu")
    public void userClicksLogInMenu() {
        homePage.userClicksLogInMenu();
    }

    @Then("Log in form is displayed")
    public void logInFormIsDisplayed() {
        homePage.logInFormIsDisplayed();
    }

    @Given("user is on Log in form")
    public void userIsOnLogInForm() {
        homePage = new HomePage(driver);
        homePage.userIsOnLogInForm();
    }

    @When("user clicks Log in Close button")
    public void userClicksLogInCloseButton() {
        homePage.userClicksLogInCloseButton();
    }

    @Then("Log in form is closed")
    public void logInFormIsClosed() {
        homePage.logInFormIsClosed();
    }

    @When("user login with username {string}")
    public void userLoginWithUsername(String usn) {
        homePage.userLoginWithUsername(usn);
    }

    @And("user login with password {string}")
    public void userLoginWithPassword(String pass) {
        homePage.userLoginWithPassword(pass);
    }

    @And("user clicks Log in button")
    public void userClicksLogInButton() {
        homePage.userClicksLogInButton();
    }

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        homePage = new HomePage(driver);
        homePage.userIsOnHomePage();
    }

//    Contact Step

    @When("user clicks New message menu")
    public void userClicksNewMessageMenu() {
        homePage.userClicksNewMessageMenu();
    }

    @Then("New message form is displayed")
    public void newMessageFormIsDisplayed() {
        homePage.newMessageFormIsDisplayed();
    }

    @Given("user is on New message form")
    public void userIsOnNewMessageForm() {
        homePage = new HomePage(driver);
        homePage.userIsOnNewMessageForm();
    }

    @When("user clicks New message Close button")
    public void userClicksNewMessageCloseButton() {
        homePage.userClicksNewMessageCloseButton();
    }

    @Then("New message form is closed")
    public void newMessageFormIsClosed() {
        homePage.newMessageFormIsClosed();
    }

    @When("user input contact email with {string}")
    public void userInputContactEmailWith(String e_mail) {
        homePage.userInputContactEmailWith(e_mail);
    }

    @And("user input contact name with {string}")
    public void userInputContactNameWith(String name) {
        homePage.userInputContactNameWith(name);
    }

    @And("user input message with {string}")
    public void userInputMessageWith(String message) {
        homePage.userInputMessageWith(message);
    }

    @And("user clicks Send message button")
    public void userClicksSendMessageButton() {
        homePage.userClicksSendMessageButton();
    }

//    About Us Step

    @When("user clicks About us")
    public void userClicksAboutUs() {
        homePage.userClicksAboutUs();
    }

    @Then("About us content is displayed")
    public void aboutUsContentIsDisplayed() {
        homePage.aboutUsContentIsDisplayed();
    }

    @Given("user is on About us content")
    public void userIsOnAboutUsContent() {
        homePage = new HomePage(driver);
        homePage.userIsOnAboutUsContent();
    }

    @When("user clicks About us Close button")
    public void userClicksAboutUsCloseButton() {
        homePage.userClicksAboutUsCloseButton();
    }

    @Then("About us content is closed")
    public void aboutUsContentIsClosed() {
        homePage.aboutUsContentIsClosed();
    }

    @When("user clicks play button")
    public void userClicksPlayButton() {
        homePage.userClicksPlayButton();
    }

    @Then("Content start to play")
    public void contentStartToPlay() {
    }

//    Home Step

    @When("user clicks {string} on categories")
    public void userClicksOnCategories(String cat) {
        homePage.userClicksOnCategories(cat);
    }

    @Then("page display only products under {string} category")
    public void pageDisplayOnlyProductsUnderCategory(String category) {
        homePage.pageDisplayOnlyProductsUnderCategory(category);
    }

    @When("user clicks category header")
    public void userClicksCategoryHeader() {
        homePage.userClicksCategoryHeader();
    }

    @Then("products from all categories are displayed")
    public void productsFromAllCategoriesAreDisplayed() {
        homePage.allCategoryProductsAreDisplayed();
    }


    @When("user clicks {string} button")
    public void userClicksButton(String buttonType) {
        homePage.userClicksPaginationButton(buttonType);
    }

    @Then("page display {string} set of products")
    public void pageDisplaySetOfProducts(String buttonType) {
        homePage.waitForPaginationButtonToAppear(buttonType);
    }

    @When("user clicks on the {string} title")
    public void userClicksOnTheTitle(String product) {
        homePage.userClicksOnTheTitle(product);
    }

    @Then("user redirect to home page")
    public void userRedirectToHomePage() {
        homePage = new HomePage(driver);
        homePage.userIsOnHomePage();
    }


    @When("user clicks Cart on Navbar")
    public void userClicksCartOnNavbar() {
        homePage = new HomePage(driver);
        homePage.userClicksCartOnNavbar();
    }

    @When("user clicks {string} arrow on carousel")
    public void userClicksArrowOnCarousel(String arrowDirection) {
        homePage.userClicksArrowOnCarousel(arrowDirection);
    }

    @Then("carousel slides")
    public void carouselSlides() {
        homePage.carouselSlides();
    }
}
