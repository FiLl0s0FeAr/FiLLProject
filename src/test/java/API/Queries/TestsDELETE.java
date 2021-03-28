package API.Queries;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestsDELETE {
    @Test
    @Description("Delete user")
    public void deleteUser(){
        given().when().delete("https://reqres.in/api/users/2").
                then().assertThat().statusCode(204);
    }
}
