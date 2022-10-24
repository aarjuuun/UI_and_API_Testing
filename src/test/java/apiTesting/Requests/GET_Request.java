package apiTesting.Requests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GET_Request {
    public static void checkStatusCode()
    {
        given().
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(200);

    }
    public static void getAllLogDetails()
    {
        given().
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(200).
        log().all();

    }
    public static void getInfoOfParticularUser()
    {
        given().
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(200).
        body("data.id[1]",equalTo(8)).
                log().all();
    }
    public static void selectParticularUser()
    {
        given().
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(200).
        body("data.id[1]",equalTo(8)).
                body("data.first_name",hasItems("Michael","Lindsay"));
    }
}
