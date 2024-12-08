package API.Queries;

import API.DTO.TestsGET.SignleUser;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestsGET {

    @Test
    @Description("get information about single user")
    public void getSingleUser(){
        SignleUser responseSingleUser = given().get("https://reqres.in/api/users/2").
                then().assertThat().statusCode(200).
                and().extract().as(SignleUser.class);

        Assert.assertEquals(responseSingleUser.getData().get("id").asInt(), 2);
        Assert.assertEquals(responseSingleUser.getData().get("email").asText(), "janet.weaver@reqres.in");
        Assert.assertEquals(responseSingleUser.getSupport().get("text").asText(), "To keep ReqRes free, contributions towards server costs are appreciated!");
    }

    @Test
    @Description("singe user not found")
    public void getSingleUserNotFound(){
        given().when().get("https://reqres.in/api/users/23").
                then().assertThat().statusCode(404);
    }
}
