package apiAuto.pages;

import apiAuto.helper.EndPoint;
import apiAuto.helper.Utillity;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static apiAuto.helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    String setURL,globalId;

    Response res;

    public void prepareURL(String url){
        switch (url){
            case "GET_LIST_USERS":
                setURL = EndPoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USERS":
                setURL = EndPoint.CREATE_NEW_USERS;
                break;
            case "DELETE_USERS":
                setURL = EndPoint.DELETE_USERS;
                break;
            default:
                System.out.println("input right url");
        }
        System.out.println("endpoint ready to use: " + setURL);
    }

    public void hitApiGetListUsers(){
        res = getListUsers(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitApiPostListUsers(){
        res = postCreateUser(setURL);
    }

    public void hitApiDeleteUsers(){
        res = deleteUser(setURL, globalId);
    }

    public void hitApiUpdateUsers(){
        res = updateUser(setURL, globalId);
    }

    public void validationStatusCodeIsEquals(int status){
        assertThat(res.statusCode()).isEqualTo(status);
    }

    public void validationResponseBodyGetListUsers(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }

    public void validationJsonWithJSONSchema(String filename){
        File JSONFile = Utillity.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void validationResponseBodyCreateUsers(){
        JsonPath jasonPathEvaluator = res.jsonPath();
        Integer id = jasonPathEvaluator.get("id");
        String name = jasonPathEvaluator.get("name");
        String email = jasonPathEvaluator.get("email");
        String gender = jasonPathEvaluator.get("gender");
        String status = jasonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        globalId = Integer.toString(id);
    }

    public void validationResponseBodyUpdateUsers(){
        JsonPath jasonPathEvaluator = res.jsonPath();
        Integer id = jasonPathEvaluator.get("id");
        String name = jasonPathEvaluator.get("name");
        String email = jasonPathEvaluator.get("email");
        String gender = jasonPathEvaluator.get("gender");
        String status = jasonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        globalId = Integer.toString(id);
    }
}
