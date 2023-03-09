package adapters;


import core.configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;


public class Specification {
    private static RequestSpecificationImpl requestSpecBuilder = null;

    public static RequestSpecificationImpl requestSpecification(String url) {
        if (requestSpecBuilder == null) {
            Specification.requestSpecBuilder = (RequestSpecificationImpl) new RequestSpecBuilder()
                    .setBaseUri(url)
                    .setContentType(ContentType.JSON)
                    .addHeader("Authorization", "Bearer " + ReadProperties.getApiConfig().token())
                    .setAccept("application/vnd.github+json")
                    .build();
        }
        return Specification.requestSpecBuilder;
    }

    public static void installRequestSpecification(RequestSpecification request) {
        RestAssured.requestSpecification = request;
    }
}
