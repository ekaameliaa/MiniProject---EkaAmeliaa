package starter.pages.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllProduct {
    public static String token = "";
    public String endpoint = "https://altashop-api.fly.dev/api/auth";
    public String endpointProduct = "https://altashop-api.fly.dev/api/products";
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

    @Step("I set GET api endpoints Get All Product")
    public String setApiEndpointGetAllProduct() {
        return endpointProduct;
    }

    @Step("I send GET HTTP request Get All Product")
    public void sendGetHttpRequestGetAllProduct() {
        SerenityRest.given().header("Authorization","Bearer " + token).get(setApiEndpointGetAllProduct());
    }

    @Step("I receive valid HTTP response code Get All Product 200")
    public void validateResponseCodeGetAllProduct() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I send invalid HTTP request Get All Product")
    public void sendInvalidHttpRequestGetAllProduct() {
        SerenityRest.given().header("Authorization","Bearer " + token).post(setApiEndpointGetAllProduct());
    }

    @Step("I receive invalid HTTP response code Get All Product 200")
    public void invalidateResponseCodeGetAllProduct() {
        restAssuredThat(response -> response.statusCode(400));
    }

}
