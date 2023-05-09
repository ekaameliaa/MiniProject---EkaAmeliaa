package starter.pages.orders;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetOrderID {
    public static String token = "";
    public String endpoint = "https://altashop-api.fly.dev/api/auth";
    public String endpointOrder = "https://altashop-api.fly.dev/api/orders/10297";
    public String invalidEndpoint = "https://altashop-api.fly.dev/api/orders/2";
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

    @Step("I set GET api endpoints Get Order")
    public String setApiEndpointGetOrder() {
        return endpointOrder;
    }

    @Step("I send GET HTTP request Get Order")
    public void sendGetHttpRequestGetOrder() {
        SerenityRest.given().header("Authorization","Bearer " + token).get(setApiEndpointGetOrder());
    }

    @Step("I receive valid HTTP response code Get order 200")
    public void validateResponseCodeGetOrder() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I send invalid GET HTTP request Get Order")
    public void sendInvalidGetHttpRequestGetOrder() {
        SerenityRest.given().header("Authorization","Bearer " + token).get(invalidEndpoint);
    }

    @Step("I receive invalid HTTP response code Get order 200")
    public void invalidateResponseCodeGetOrder() {
        restAssuredThat(response -> response.statusCode(404));
    }
}
