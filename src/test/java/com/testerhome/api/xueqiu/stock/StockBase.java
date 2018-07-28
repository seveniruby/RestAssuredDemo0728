package com.testerhome.api.xueqiu.stock;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StockBase {
    public static RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    public static RequestSpecification requestSpecification;
    public static String token = "8cf0a4031156698597e6621cf7ad44f3f01acee1";
    public static String uid = "5708953570";
    public static Boolean isLogin = true;
    public static String currentEnv=System.getenv("env");


    @BeforeClass
    public static void beforeClass() {
        RestAssured.useRelaxedHTTPSValidation();
        if (isLogin == false) {
            login();
        }
        if(requestSpecification==null){
            requestSpecBuilder.addHeader("Host", "api.xueqiu.com");
            requestSpecBuilder.addHeader("User-Agent", "Xueqiu Android 8.7-rc-1618");
            requestSpecBuilder.addCookie("u", uid);
            requestSpecBuilder.addCookie("xq_a_token", token
            );
            requestSpecBuilder.addQueryParam("_t", "1GENYMOTION66adefb1e7e6e9882dc08ac85ab792b3.7160412574.1532745299823.1532748254236");
            requestSpecBuilder.addQueryParam("_s", "ca0da7");
            requestSpecBuilder.addQueryParam("x", "0.248");
            System.out.println("BeforeClass");
            requestSpecification = requestSpecBuilder.build();
        }
    }

    public static void login() {
        Response response = given().header("Host", "api.xueqiu.com")
                .header("User-Agent", "Xueqiu Android 8.7-rc-1618")
                .formParam("sid", "1GENYMOTION66adefb1e7e6e9882dc08ac85ab792b3")
                .formParam("client_id", "JtXbaMn7eP")
                .formParam("telephone", "15600534760")
                .formParam("client_secret", "txsDfr9FphRSPov5oQou74")
                .formParam("grant_type", "password")
                .formParam("areacode", "86")
                .formParam("password", "9ae503c3b257f00d47cb6e5f3a26334e")
                .when().log().all().post("https://101.201.62.20:443/provider/oauth/token?_t=1GENYMOTION66adefb1e7e6e9882dc08ac85ab792b3.7160412574.1532745299823.1532766488180&amp;_s=25bb34")
                .then().log().all()
                .statusCode(400).extract().response();
        token = response.path("error_id");
        uid = response.path("uid");
        isLogin = true;

    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass");
        //todo:注销
    }

}


