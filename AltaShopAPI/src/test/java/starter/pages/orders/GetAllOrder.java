package starter.pages.orders;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.pages.LoginToken;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllOrder {

    public static String token = "";
    public String endpoint = "https://altashop-api.fly.dev/api/auth";
    public String endpointOrder = "https://altashop-api.fly.dev/api/orders";
    @Step("I have endpoint auth")
    public String setPostEndpointAuth(){
        return endpoint + "/login";
    }

    @Step ("I Send endpoint auth")
    public void sendEndpointAuth(){
        String body = "{\n" +
                "    \"email\":\"ekaameliaputri17@gmail.com\",\n" +
                "    \"password\":\"eka123\"\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setPostEndpointAuth());
        token = lastResponse().getBody().jsonPath().get("data");
    }

    @Step("I set GET api endpoints Get All Order")
    public String setApiEndpointGetAllOrder() {
        return endpointOrder;
    }

    @Step("I send GET HTTP request Get All Order")
    public void sendGetHttpRequestGetAllOrder() {
        SerenityRest.given().header("Authorization","Bearer " + token).get(setApiEndpointGetAllOrder());
    }

    @Step("I receive valid HTTP response code Get All order 200")
    public void validateResponseCodeGetAllOrder() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I send invalid GET HTTP request Get All Order")
    public void sendInvalidGetHttpRequestGetAllOrder() {
        SerenityRest.given().header("Authorization","Bearer " + token).post(setApiEndpointGetAllOrder());
    }

    @Step("I receive invalid HTTP response code Get All order 404")
    public void invalidateResponseCodeGetAllOrder() {
        restAssuredThat(response -> response.statusCode(400));
    }
}
