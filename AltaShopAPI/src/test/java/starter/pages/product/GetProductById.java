package starter.pages.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetProductById {
    public static String token = "";
    public String endpoint = "https://altashop-api.fly.dev/api/auth";
    public String endpointProduct = "https://altashop-api.fly.dev/api/products/14482";
    public String invalidEndpoint = "https://altashop-api.fly.dev/api/products/2";
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

    @Step("I set GET api endpoints Get product by id")
    public String setApiEndpointGetProduct() {
        return endpointProduct;
    }

    @Step("I send GET HTTP request Get Product By Id")
    public void sendGetHttpRequestGetProduct() {
        SerenityRest.given().header("Authorization","Bearer " + token).get(setApiEndpointGetProduct());
    }

    @Step("I receive valid HTTP response code Get product by id 200")
    public void validateResponseCodeGetProduct() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I send invalid endpoint HTTP request Get Order")
    public void sendInvalidHttpRequestGetProduct() {
        SerenityRest.given().header("Authorization","Bearer " + token).get(invalidEndpoint);
    }

    @Step("I receive invalid HTTP response code Get product by id 200")
    public void invalidateResponseCodeGetProduct() {
        restAssuredThat(response -> response.statusCode(404));
    }
}
