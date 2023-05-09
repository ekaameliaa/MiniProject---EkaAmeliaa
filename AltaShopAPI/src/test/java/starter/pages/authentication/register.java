package starter.pages.authentication;

import com.github.javafaker.Faker;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class register {
    public String endpoint = "https://altashop-api.fly.dev/api/auth/register";

    @Step("I set endpoint Register")
    public String setPostEndpointRegister() {
        return endpoint;
    }

    @Step("i send method post endpoint register")
    public void sendPostHttpRequestRegister() {

        Faker faker = new Faker();
        int min = 1;
        int max= 1000000000;
        int number = (int)Math.floor(Math.random() * (max - min + 1) + min );

        String email = "eka" + String.valueOf(number) + faker.name().username() + "@gmail.com";
        String body = "{\n" +
                "    \"email\":" +email + ",\n" +
                "    \"password\":\"ekaa123\",\n" +
                "    \"fullname\":\"Eka Amelia\"\n" +
                "}";


        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setPostEndpointRegister());
    }

    @Step("i see response code register 200")
    public void validateResponseCodRegister() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("i send method invalid endpoint register")
    public void sendInvaidMethodRegister() {

        String body = "{\n" +
                "    \"email\":\"ekaameliaputri@gmail.com\",\n" +
                "    \"password\":\"123123\",\n" +
                "    \"fullname\":\"Eka Amelia Putri\"\n" +
                "}";


        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).get(setPostEndpointRegister());
    }

    @Step("i see response code failregister 200")
    public void validateResponseCodefailregister() {
        restAssuredThat(response -> response.statusCode(405));
    }
}
