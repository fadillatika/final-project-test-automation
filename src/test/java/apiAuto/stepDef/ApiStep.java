package apiAuto.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import apiAuto.pages.ApiPage;

public class ApiStep {

    ApiPage apiPage;

    public ApiStep(){
        this.apiPage = new ApiPage();
    }

    @Given("prepare url valid for {string}")
    public void prepareUrlValidFor(String url) {
        apiPage.prepareURL(url);
    }

    @And("hit API get list data")
    public void hitAPIGetListData() {
        apiPage.hitApiGetListUsers();
    }

    @And("hit API post create new user")
    public void hitAPIPostCreateNewUser() {
        apiPage.hitApiPostListUsers();
    }

    @And("hit API delete user")
    public void hitAPIDeleteUser() {
        apiPage.hitApiDeleteUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status) {
        apiPage.validationStatusCodeIsEquals(status);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response body post list users")
    public void validationResponseBodyPostListUsers() {
        apiPage.validationResponseBodyCreateUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationJsonWithJSONSchema(filename);
    }

    @And("hit API update user")
    public void hitAPIUpdateUser() {
        apiPage.hitApiUpdateUsers();
    }

    @Then("validation response body update users")
    public void validationResponseBodyUpdateUsers() {
        apiPage.validationResponseBodyUpdateUsers();
    }
}
