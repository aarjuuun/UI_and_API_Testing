package apiTesting;

import apiTesting.Requests.GET_Request;
import apiTesting.Requests.POST_Request;
import org.testng.annotations.Test;

public class testCases {

    @Test(description = "Implementing GET request")
    public static void implementGet()
    {
        GET_Request.checkStatusCode();
        GET_Request.getAllLogDetails();
        GET_Request.getInfoOfParticularUser();
        GET_Request.selectParticularUser();
    }

    @Test(description = "Implementing POST request")
    public static void implementPost()
    {
        POST_Request.insertNewUser();
    }
}
