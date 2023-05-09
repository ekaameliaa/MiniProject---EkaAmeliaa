package starter.pages.authentication;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetUser {

    public static String token = "";
    public String endpoint = "https://altashop-api.fly.dev/api/auth";

    @Step("I set get api endpoint auth")
    public String setApiEndpointAuth(){
        return endpoint + "/login";
    }

    @Step("I send Get HTTP Request endpoint auth")
    public void sendGetHttpRequestEndpointAuth(){
        String body = "{\n" +
                "    \"email\":\"ekaameliaputri17@gmail.com\",\n" +
                "    \"password\":\"eka123\"\n" +
                "}";

        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setApiEndpointAuth());
        token = lastResponse().getBody().jsonPath().get("data");
    }
    @Step("I set GET api endpoints Get All User")
    public String setApiEndpointGetUser() {
        return endpoint + "/info";
    }

    @Step("I send GET HTTP request Get All User")
    public void sendGetHttpRequestGetAllUser() {

        SerenityRest.given().header("Authorization","Bearer " + token).get(setApiEndpointGetUser());
    }

    @Step("I receive valid HTTP response code Get user 200")
    public void validateResponseCodeGetUser200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I send invalid method request Get All User")
    public void sendInvalidMethodGetUser() {
        SerenityRest.given().post(setApiEndpointGetUser());
    }

    @Step("I receive valid HTTP response code failed Get user 405")
    public void validateResponseCodeFailGetUser() {
        restAssuredThat(response -> response.statusCode(405));
    }
}
