package starter.pages.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetCommentProduct {
    public static String token = "";
    public String endpoint = "https://altashop-api.fly.dev/api/auth";
    public String endpointProduct = "https://altashop-api.fly.dev/api/products/2/comments";
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

    @Step("I set GET api endpoints Get Comment product by id")
    public String setApiEndpointGetCommentProduct() {
        return endpointProduct;
    }

    @Step("I send GET HTTP request Get Comment Product By Id")
    public void sendGetHttpRequestGetCommentProduct() {
        SerenityRest.given().header("Authorization","Bearer " + token).get(setApiEndpointGetCommentProduct());
    }

    @Step("I receive valid HTTP response code Get Comment product by id 200")
    public void validateResponseCodeGetCommentProduct() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I send invalid endpoint HTTP request Get Comment Product")
    public void sendInvalidMethodGetCommentProduct() {
        SerenityRest.given().header("Authorization","Bearer " + token).put(setApiEndpointGetCommentProduct());
    }

    @Step("I receive invalid HTTP response code Get rate product by id")
    public void invalidateResponseCodeGetCommentProduct() {
        restAssuredThat(response -> response.statusCode(405));
    }
}
