package test;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostMethod {
    public static void main(String[] args) {

        //RequestSpecification object
        String baseURL = "https://jsonplaceholder.typicode.com/";
        RequestSpecification request = given();
        request.baseUri(baseURL);

        //Content-type -> Header

        request.header(new Header("Content-type", "application/json; charset=UTF-8"));

        //Form up request body
        String postBody ="{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"The req's title\",\n" +
                "  \"body\": \"The req's body\"\n" +
                "}";


        //Send POST request
       Response response = request.body(postBody).post("/posts");
       response.prettyPrint();

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());

        //Verification
        response.then().statusCode(equalTo(201));
        response.then().statusLine(containsStringIgnoringCase("201"));
        response.then().body("userId", equalTo(1));
        System.out.println("Hola mundo");
        System.out.println("Holi");
    }
}
