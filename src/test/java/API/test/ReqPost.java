package API.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ReqPost {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/api";

        String requestBody = "{\n" +
                "  \"name\": \"John\",\n" +
                "  \"job\": \"Software Engineer\"\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json") 
                .body(requestBody)                          
                .when()
                .post("/users")                             
                .then()
                .contentType(ContentType.JSON)              
                .extract()
                .response();                                

        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());

        System.out.println("Response Status Code:");
        System.out.println(response.getStatusCode());

        System.out.println("Response Time (ms):");
        System.out.println(response.getTime());
    }
}
