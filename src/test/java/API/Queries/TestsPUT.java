package API.Queries;

import API.DTO.TestsPUTnPATCH.UserResponsePUTnPATCH;
import API.DTO.TestsPOST.CreateUser.UserRequestCreate;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestsPUT {

    @Test
    @Description("Update user PUT Query")
    public void putResponseWithRequest(){
        UserRequestCreate userRequestPUT = new UserRequestCreate("morpheus", "zion resident");

        UserResponsePUTnPATCH userResponsePUTnPATCH = given().body(userRequestPUT).
                when().put("https://reqres.in/api/users/2").
                then().assertThat().statusCode(200).
                and().extract().as(UserResponsePUTnPATCH.class);

        System.out.println(userResponsePUTnPATCH.getUpdatedAt());
    }
}
