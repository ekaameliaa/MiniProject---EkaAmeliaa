package starter.pages.authentication;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class login {
    public String endpoint = "https://altashop-api.fly.dev/api/auth/login";

    @Step("I have endpoint login")
    public String setPostEndpointLogin() {
        return endpoint;
    }

    @Step("i send method post endpoint login")
    public void sendPostHttpRequestLogin() {

        String body = "{\n" +
                "    \"email\":\"ekaameliaputri17@gmail.com\",\n" +
                "    \"password\":\"eka123\"\n" +
                "}";


        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setPostEndpointLogin());
    }

    @Step("i see response code login")
    public void validateResponseCodeLogin() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("i send method invalid endpoint login")
    public void sendMethodInvalidRequestLogin() {

        String body = "{\n" +
                "    \"email\":\"ekaameliaputri17@gmail.com\",\n" +
                "    \"password\":\"eka123\"\n" +
                "}";


        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).get(setPostEndpointLogin());
    }

    @Step("i see response code login")
    public void validateResponseCodeFailLogin() {
        restAssuredThat(response -> response.statusCode(405));
    }

    @Step("i send invalid data login")
    public void sendInvalidDataLogin() {

        String body = "{\n" +
                "    \"email\":\"ekaameliaputri\",\n" +
                "    \"password\":\"123123\"\n" +
                "}";


        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setPostEndpointLogin());
    }

    @Step("i see response code login")
    public void validateResponseCodeFailedLogin() {
        restAssuredThat(response -> response.statusCode(400));
    }

}
