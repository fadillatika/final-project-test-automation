package apiAuto.helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static apiAuto.helper.Utillity.generateRandomEmail;

public class Models {

    private static RequestSpecification request;

    public static void setupHeaders(){
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 8a1d0941b521979204b4b0b361f0d0b2bd3b4801a2e0b1ac1297439219796676");
    }

    public static Response getListUsers(String endpoint){
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response postCreateUser(String endpoint){
        String name = "tiks";
        String gender = "female";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response deleteUser(String endpoint, String userId){
        setupHeaders();
        String finalEndPoint = endpoint  + "/" + userId;
        return request.when().delete(finalEndPoint);
    }

    public static Response updateUser(String endpoint, String userId){
        setupHeaders();

        String name = "tikss";
        String gender = "female";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        String finalEndPoint = endpoint  + "/" + userId;
        return request.when().body(payload.toString()).when().patch(finalEndPoint);
    }
}
