package adapters;


import configurationForApi.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class Specification {
    public static RequestSpecification requestSpecification(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + ReadProperties.token())
                .setAccept("application/vnd.github+json")
                .build();
    }

    public static void installRequestSpecification(RequestSpecification request) {
        RestAssured.requestSpecification = request;
    }
}
