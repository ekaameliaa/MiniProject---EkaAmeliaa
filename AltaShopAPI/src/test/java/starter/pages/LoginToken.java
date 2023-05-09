package starter.pages;

import net.thucydides.core.annotations.Step;

import net.serenitybdd.rest.SerenityRest;

import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
public class LoginToken {
    public static String token = "";
    public String endpoint = "https://altashop-api.fly.dev/api/auth";
    @Step("I have endpoint auth")
    public String setPostEndpointAuth(){
        return endpoint + "/login";
    }

    @Step ("I Send endpoint auth")
    public void sendEndpointAuth(){
        String body = "{\n" +
                "    \"email\":\"ekaameliaputri17@gmail.com\",\n" +
                "    \"password\":\"123123\"\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setPostEndpointAuth());
        token = lastResponse().getBody().jsonPath().get("data");
    }
}
