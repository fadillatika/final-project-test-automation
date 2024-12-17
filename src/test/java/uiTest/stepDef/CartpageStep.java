package uiTest.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.baseTest;
import uiTest.pages.CartPage;

import java.util.List;
import java.util.Map;

public class CartpageStep extends baseTest {

    protected CartPage cartPage;

    @Then("user redirect to cart page")
    public void userRedirectToCartPage() {
        cartPage = new CartPage(driver);
        cartPage.goToCartPage();
    }

    @Given("user is on cart page")
    public void userIsOnCartPage() {
        cartPage = new CartPage(driver);
        cartPage.userIsOnCartPage();
    }

    @When("user clicks on the brand logo")
    public void userClicksOnTheBrandLogo() {
        cartPage.userClicksOnTheBrandLogo();
    }

    @Then("ensure the product appears in the cart")
    public void ensureTheProductAppearsInTheCart(List<String> expectedItem) {
        cartPage.ensureTheProductAppearsInTheCart(expectedItem);
    }

    @Then("ensure that the product price displayed in the cart matches")
    public void ensureThatTheProductPriceDisplayedInTheCartMatches(Map<String, Integer> expectedPrices) {
        cartPage.ensureProductPriceMatches(expectedPrices);
    }

    @Then("ensure that the number of products in the cart is as added")
    public void ensureThatTheNumberOfProductsInTheCartIsAsAdded(List<String> expectedProducts) {
        cartPage.ensureProductCountMatches(expectedProducts);
    }

    @Then("total price is correct")
    public void totalPriceIsCorrect(Map<String, Integer> expectedPrices) {
        cartPage.totalPriceIsCorrect(expectedPrices);
    }

    @When("user accesses cart page")
    public void userAccessesCartPage() {
        cartPage = new CartPage(driver);
        cartPage.userIsOnCartPage();
    }

    @And("user clicks delete button on {string}")
    public void userClicksDeleteButtonOn(String delProd) {
        cartPage.userClicksDeleteButton(delProd);
    }

    @Then("product {string} deleted")
    public void productDeleted(String deleted) {
        cartPage.productDeleted(deleted);
    }

    @And("user clicks place order button")
    public void userClicksPlaceOrderButton() {
        cartPage.userClicksPlaceOrderButton();
    }

    @Then("form of data to fill in appears")
    public void formOfDataToFillInAppears() {
        cartPage = new CartPage(driver);
        cartPage.formOfDataToFillInAppears();
    }

    @Then("total price in form is correct")
    public void totalPriceInFormIsCorrect() {
        cartPage.totalPriceInFormIsCorrect();
    }

    @Given("form data to fill in appears")
    public void formDataToFillInAppears() {
        cartPage = new CartPage(driver);
        cartPage.userIsOnCartPage();
        cartPage.userClicksPlaceOrderButton();
        cartPage.formOfDataToFillInAppears();
    }

    @When("user input name with {string}")
    public void userInputNameWith(String name) {
        cartPage.userInputNameWith(name);
    }

    @And("user input country with {string}")
    public void userInputCountryWith(String country) {
        cartPage.userInputCountryWith(country);
    }

    @And("user input city with {string}")
    public void userInputCityWith(String city) {
        cartPage.userInputCityWith(city);
    }

    @And("user input credit card with {string}")
    public void userInputCreditCardWith(String card) {
        cartPage.userInputCreditCardWith(card);
    }

    @And("user input month with {string}")
    public void userInputMonthWith(String month) {
        cartPage.userInputMonthWith(month);
    }

    @And("user input year with {string}")
    public void userInputYearWith(String year) {
        cartPage.userInputYearWith(year);
    }

    @Then("user clicks purchase button")
    public void userClicksPurchaseButton() {
        cartPage.userClicksPurchaseButton();
    }

    @Then("user successfully purchases product")
    public void userSuccessfullyPurchasesProduct() {
        cartPage.userSuccessfullyPurchasesProduct();
    }

    @Then("pop-up {string} on cart appears")
    public void popUpOnCartAppears(String popUpMessage) {
        cartPage.popUpOnCartAppears(popUpMessage);
    }

    @When("successfully purchases product")
    public void successfullyPurchasesProduct() {
        cartPage.userClicksPurchaseButton();
    }

    @Then("alert message displayed")
    public void alertMessageDisplayed() {
        cartPage.userSuccessfullyPurchasesProduct();
    }
}
