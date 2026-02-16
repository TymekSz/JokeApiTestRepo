package helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderProvider {

    public static RequestSpecification getRequestSpecBuilder() {
        return new RequestSpecBuilder()
                .setBaseUri("https://official-joke-api.appspot.com/")
                .setContentType(ContentType.JSON)
                .build();
    }
}