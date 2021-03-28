package API.Queries;

import API.DTO.TestsPOST.CreateUser.UserRequestCreate;
import API.DTO.TestsPOST.CreateUser.UserResponseCreate;
import API.DTO.TestsPOST.RegAndLogin.UserRequestRegAndLogin;
import API.DTO.TestsPOST.RegAndLogin.UserResponseRegAndLogin;

import io.restassured.http.ContentType;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class TestsPOST {

    @Test
    @Description("Post test to create a user with request name + job")
    public void postCreateSingleUserWithRequest(){
        UserRequestCreate userRequestCreate = new UserRequestCreate("morpheus", "leader");

        UserResponseCreate userResponseCreate = given().body(userRequestCreate).
                when().post("https://reqres.in/api/users").
                then().assertThat().statusCode(201).
                and().extract().as(UserResponseCreate.class);

        System.out.println("POST:");
        System.out.println("id: " + userResponseCreate.getId() + "  || createdAt: " + userResponseCreate.getCreatedAt());
    }

    @Test
    @Description("Post to successfully register")
    public void postRegisterSuccessful(){
        UserRequestRegAndLogin userRequestRegAndLogin = new UserRequestRegAndLogin("eve.holt@reqres.in", "pistol");

        UserResponseRegAndLogin userResponseRegAndLogin = given().contentType(ContentType.JSON).
                body(userRequestRegAndLogin).
                post("https://reqres.in/api/register").
                then().assertThat().statusCode(200).
                and().extract().as(UserResponseRegAndLogin.class);

        Assert.assertEquals(userResponseRegAndLogin.getId(), 4);
        Assert.assertEquals(userResponseRegAndLogin.getToken(), "QpwL5tke4Pnpja7X4");
    }

    @Test
    @Description("Post to unsuccessfully register")
    public void postRegisterUnsuccessful(){
        UserRequestRegAndLogin userRequestRegAndLogin = new UserRequestRegAndLogin("sydney@fife");

        UserResponseRegAndLogin userResponseRegAndLogin = given().contentType(ContentType.JSON).
                body(userRequestRegAndLogin).post("https://reqres.in/api/register").
                then().assertThat().statusCode(400).
                and().extract().as(UserResponseRegAndLogin.class);

        Assert.assertEquals(userResponseRegAndLogin.getError(), "Missing password");
    }

    @Test
    @Description("Post to successfully login")
    public void postLoginSuccessful(){
        UserRequestRegAndLogin userRequestRegAndLogin = new UserRequestRegAndLogin("eve.holt@reqres.in", "cityslicka");

        UserResponseRegAndLogin userResponseRegAndLogin = given().contentType(ContentType.JSON).
                body(userRequestRegAndLogin).post("https://reqres.in/api/login").
                then().assertThat().statusCode(200).
                and().extract().as(UserResponseRegAndLogin.class);

        Assert.assertEquals(userResponseRegAndLogin.getToken(), "QpwL5tke4Pnpja7X4");
    }

    @Test
    @Description("Post to unsuccessfully login")
    public void postLoginUnsuccessful(){
        UserRequestRegAndLogin userRequestRegAndLogin = new UserRequestRegAndLogin("peter@klaven");

        UserResponseRegAndLogin userResponseRegAndLogin = given().contentType(ContentType.JSON).
                body(userRequestRegAndLogin).post("https://reqres.in/api/login").
                then().assertThat().statusCode(400).
                and().extract().as(UserResponseRegAndLogin.class);

        Assert.assertEquals(userResponseRegAndLogin.getError(), "Missing password");
    }
}
