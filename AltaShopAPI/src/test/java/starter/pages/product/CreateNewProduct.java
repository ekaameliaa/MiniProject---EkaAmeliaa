package starter.pages.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateNewProduct {
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

    @Step("I set endpoint post new product")
    public String setPostEndpointNewProduct() {
        return endpointProduct;
    }

    @Step("i send post endpoint add new product")
    public void sendPostHttpRequestNewProduct() {

        String body = "{\n" +
                "    \"name\":\"Sony 6000\",\n" +
                "    \"description\":\"play has no limits\",\n" +
                "    \"price\":599,\n" +
                "    \"categories\":[\n" +
                "        6\n" +
                "    ]\n" +
                "}";


        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization","Bearer " + token).body(reqBody.toString()).post(setPostEndpointNewProduct());
    }

    @Step("i see response code new product 201")
    public void validateHttpResponseCodeNewProduct200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("i send invalid data add new product")
    public void sendInvalidDataRequestNewProduct() {

        String body = "{\n" +
                "    \"name\":\"Sony 6000\",\n" +
                "    \"description\":\"play has no limits\",\n" +
                "    \"price\":\"LimaRibu\",\n" +
                "    \"categories\":[\n" +
                "        6\n" +
                "    ]\n" +
                "}";


        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization","Bearer " + token).body(reqBody.toString()).post(setPostEndpointNewProduct());
    }

    @Step("i see response code failed new product 400")
    public void invalidateHttpResponseCodeNewProduct() {
        restAssuredThat(response -> response.statusCode(400));
    }

}
