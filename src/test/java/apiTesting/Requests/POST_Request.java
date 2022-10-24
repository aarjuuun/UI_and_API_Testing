package apiTesting.Requests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class POST_Request {
    public static void insertNewUser()
    {
        JSONObject request = new JSONObject();
        request.put("name","Arjun");
        request.put("job","SDET");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/json").
        contentType(ContentType.JSON).
                accept(ContentType.JSON).
        body(request.toJSONString()).
                when().
        post("https://reqres.in/api/users").
                then().
        statusCode(201); //if 200 is given then it would not be true
    }
}
