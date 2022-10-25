package apiTesting;

import apiTesting.Requests.GET_Request;
import apiTesting.Requests.POST_Request;
import org.testng.annotations.Test;

public class testCases {

    @Test(description = "Implementing GET request")
    public static void implementGet()
    {
        GET_Request.checkStatusCode();
        System.out.println("--------------------------------------------------------");
        GET_Request.getAllLogDetails();
        System.out.println("--------------------------------------------------------");
        GET_Request.getInfoOfParticularUser();
        System.out.println("--------------------------------------------------------");
        GET_Request.selectParticularUser();
        System.out.println("--------------------------------------------------------");

    }

    @Test(description = "Implementing POST request")
    public static void implementPost()
    {
        POST_Request.insertNewUser();
    }
}
