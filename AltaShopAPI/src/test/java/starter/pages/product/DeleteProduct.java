package starter.pages.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteProduct {
    public static String token = "";
    public String endpoint = "https://altashop-api.fly.dev/api/auth";
    public String endpointProduct = "https://altashop-api.fly.dev/api/products/12052";
//    public String invalidEndpoint = "https://altashop-api.fly.dev/api/products/2";
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

    @Step("I set Delete api endpoints delete product")
    public String setApiEndpointDeleteProduct() {
        return endpointProduct;
    }

    @Step("I send Delete HTTP request Delete Product")
    public void sendDeleteHttpRequestGetProduct() {
        SerenityRest.given().header("Authorization","Bearer " + token).delete(setApiEndpointDeleteProduct());
    }

    @Step("I receive valid HTTP response code Delete product 200")
    public void validateResponseCodeDeleteProduct() {
        restAssuredThat(response -> response.statusCode(200));
    }
}
