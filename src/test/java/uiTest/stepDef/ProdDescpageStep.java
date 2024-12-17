package uiTest.stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.baseTest;
import uiTest.pages.ProdDescPage;


public class ProdDescpageStep extends baseTest {

    protected ProdDescPage prodDescPage;

    @Then("user redirect to {string} description")
    public void userRedirectToDescription(String prodTitle) {
        prodDescPage = new ProdDescPage(driver);
        prodDescPage.goToProdDescPage(prodTitle);
    }

    @Given("user is on {string} description product")
    public void userIsOnDescriptionProduct(String productDescript) {
        prodDescPage = new ProdDescPage(driver);
        prodDescPage.userIsOnDescriptionProduct(productDescript);
    }

    @When("user clicks add to cart button")
    public void userClicksAddToCartButton() {
        prodDescPage.userClicksAddToCartButton();
    }

    @Then("pop-up {string} appears")
    public void popUpAppears(String popUpMessage) {
        prodDescPage.popUpAppears(popUpMessage);
    }

    @Given("user has added")
    public void userHasAdded(DataTable productsTable) {
        prodDescPage = new ProdDescPage(driver);
        prodDescPage.userHasAddedProductsToCart(productsTable);
    }

    @Given("user success placing orders")
    public void userSuccessPlacingOrders(DataTable productsName) {
        prodDescPage = new ProdDescPage(driver);
        prodDescPage.userSuccessPlacingOrders(productsName);
    }

}
