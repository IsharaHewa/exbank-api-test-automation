package com.api.api.common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static com.api.api.common.Constants.BASE_URL;

public class SpecBuilder {

    // POST Request Specification Builder with JSON Body
    public static RequestSpecification postRequestSpecificationBuilder(String url, String jsonBody) {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(url)
                .setAccept(ContentType.JSON)
                .setBody(jsonBody)
                .build();
        return requestSpec;
    }
    // GET Request Specification Builder
    public static RequestSpecification getRequestSpecificationBuilder(String url) {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(url)
                .setAccept(ContentType.JSON)
                .build();
        return requestSpec;
    }
}
