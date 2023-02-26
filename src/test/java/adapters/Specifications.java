package adapters;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static RequestSpecification requestSpecification(String url){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }
    public static ResponseSpecification responseSpecOk201(){
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }
    public static ResponseSpecification responseSpecOk422(){
        return new ResponseSpecBuilder()
                .expectStatusCode(422)
                .build();
    }
    public static ResponseSpecification responseSpecOk204(){
        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }
    public static ResponseSpecification responseSpecOk202(){
        return new ResponseSpecBuilder()
                .expectStatusCode(202)
                .build();
    }
    public static ResponseSpecification responseSpecOk200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static ResponseSpecification responseSpecOk401(){
        return new ResponseSpecBuilder()
                .expectStatusCode(401)
                .build();
    }
    public static ResponseSpecification responseSpecOk404(){
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
    }

    public static void installSpecification(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
