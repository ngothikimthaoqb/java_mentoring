package api.core;

import api.utils.Constant;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;
import java.net.URISyntaxException;

public class Builder {
    static RequestSpecification getRequestSpec() throws IOException, URISyntaxException {
        return new RequestSpecBuilder()
                .setBaseUri(Constant.URI)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
    }
}
