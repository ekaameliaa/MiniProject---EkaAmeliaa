package starter.pages.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetRateProduct {
    public static String token = "";
    public String endpoint = "https://altashop-api.fly.dev/api/auth";
    public String endpointProduct = "https://altashop-api.fly.dev/api/products/11665/ratings";
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

    @Step("I set GET api endpoints Get rate product by id")
    public String setApiEndpointGetRateProduct() {
        return endpointProduct;
    }

    @Step("I send GET HTTP request Get Rate Product By Id")
    public void sendGetHttpRequestGetRateProduct() {
        SerenityRest.given().header("Authorization","Bearer " + token).get(setApiEndpointGetRateProduct());
    }

    @Step("I receive valid HTTP response code Get rate product by id 200")
    public void validateResponseCodeGetRateProduct() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I send invalid endpoint HTTP request Get rate Product")
    public void sendInvalidMethodGetRateProduct() {
        SerenityRest.given().header("Authorization","Bearer " + token).put(setApiEndpointGetRateProduct());
    }

    @Step("I receive invalid HTTP response code Get rate product by id")
    public void invalidateResponseCodeGetRateProduct() {
        restAssuredThat(response -> response.statusCode(405));
    }
}
