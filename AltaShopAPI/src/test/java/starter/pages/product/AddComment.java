package starter.pages.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class AddComment {
    public static String token = "";
    public String endpoint = "https://altashop-api.fly.dev/api/auth";
    public String endpointProduct = "https://altashop-api.fly.dev/api/products/12887/comments";
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

    @Step("I set endpoint post add comment product")
    public String setPostEndpointAddCommentProduct() {
        return endpointProduct;
    }

    @Step("i send post endpoint add comment product ")
    public void sendPostHttpRequestAddCommentProduct() {

        String body = "{\n" +
                "    \"content\":\"the games are great including Gran Turismo 7\"\n" +
                "}";


        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization","Bearer " + token).body(reqBody.toString()).post(setPostEndpointAddCommentProduct());
    }

    @Step("i see response code add comment product 201")
    public void validateHttpResponseCodeAddCommentProduct() {
        restAssuredThat(response -> response.statusCode(200));
    }
}
