package starter.pages.orders;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.pages.LoginToken;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class NewOrder {


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

    @Step("I set endpoint post new order")
    public String setPostEndpointNewOrder() {
        return endpointOrder;
    }

    @Step("i send post endpoint add new Order")
    public void sendPostHttpRequestNewOrder() {

        String body = "{\n" +
                "        \"product_id\":11664,\n" +
                "        \"quantity\":1\n" +
                "    }";


        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization","Bearer " + token).body("[\n" + reqBody.toString() + "\n]").post(setPostEndpointNewOrder());
    }

    @Step("i see response code new order 201")
    public void validateHttpResponseCodeNewOrder200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("i send invalid data add new Order")
    public void sendInvalidDataRequestNewOrder() {

        String body = "{\n" +
                "    \"product_id\":eka,\n" +
                "    \"quantity\":3\n" +
                "}\n";


        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization","Bearer " + token).body("[\n" + reqBody.toString() + "\n]").post(setPostEndpointNewOrder());
    }

    @Step("i see response code failed new order 400")
    public void invalidateHttpResponseCodeNewOrder() {
        restAssuredThat(response -> response.statusCode(400));
    }

}
