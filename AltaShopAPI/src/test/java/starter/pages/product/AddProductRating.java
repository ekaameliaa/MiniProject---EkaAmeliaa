package starter.pages.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class AddProductRating {
    public static String token = "";
    public String endpoint = "https://altashop-api.fly.dev/api/auth";
    public String endpointProduct = "https://altashop-api.fly.dev/api/products/14482/ratings";
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

    @Step("I set endpoint post new product rating")
    public String setPostEndpointNewProductRating() {
        return endpointProduct;
    }

    @Step("i send post endpoint add new product rating")
    public void sendPostHttpRequestNewProductRating() {

        String body = "{\n" +
                "    \"count\":5\n" +
                "}";


        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization","Bearer " + token).body(reqBody.toString()).post(setPostEndpointNewProductRating());
    }

    @Step("i see response code new product 201")
    public void validateHttpResponseCodeNewProductRating200() {
        restAssuredThat(response -> response.statusCode(200));
    }
}
