package api.core;

import io.restassured.response.Response;

import java.io.IOException;
import java.net.URISyntaxException;

import static api.core.Builder.getRequestSpec;
import static api.core.Builder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class BaseAPI {
    public static Response get(String path) throws IOException, URISyntaxException {
        return given(getRequestSpec())
                .when()
                .get(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }
}
