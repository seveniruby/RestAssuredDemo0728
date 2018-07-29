package com.testerhome.api.xueqiu.stock0729;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class Login {
    public static String token="";
    public static String uid="";

    public static RequestSpecification requestSpecification;
    @BeforeClass
    public static void login(){

        /*
        useRelaxedHTTPSValidation();
        Response response=given()
                .formParam("code", "4703")
                .queryParam("_s", "367bac")
                .formParam("telephone", "15600534760")
                .formParam("client_secret", "txsDfr9FphRSPov5oQou74")
                .queryParam("_t", "1GENYMOTION66adefb1e7e6e9882dc08ac85ab792b3.7160412574.1532866974495.1532867671838")
                .cookie("xq_a_token", "2e28c455df13d47ff87a4e9cb9afd732140603c1")
                .formParam("areacode", "86")
                .formParam("client_id", "JtXbaMn7eP")
                .cookie("u", "7160412574")
                .formParam("x", "0.2158")
                .formParam("grant_type", "no_password")
                .when().log().all().post("https://101.201.62.20:443/provider/oauth/token")
                .then().log().all()
                .statusCode(200).extract().response()
        ;

        token=response.path("access_token");
        uid=response.path("uid");
        */
        token="8cf0a4031156698597e6621cf7ad44f3f01acee1";
        uid="5708953570";

        RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
        requestSpecBuilder.addCookie("xq_a_token", token);
        requestSpecBuilder.addCookie("u", uid);
        requestSpecBuilder.addQueryParam("x", "0.1445");
        requestSpecBuilder.addQueryParam("x", "0.1445");
        requestSpecBuilder.addQueryParam("_t", "1GENYMOTION66adefb1e7e6e9882dc08ac85ab792b3.5708953570.1532866974495.1532868266730");
        requestSpecBuilder.addHeader("host", "api.xueqiu.com");
        requestSpecBuilder.addHeader("User-Agent", "Xueqiu Android 8.7-rc-1618");
        requestSpecification=requestSpecBuilder.build();

    }
}
