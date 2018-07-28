package com.testerhome.api.xueqiu.stock;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class TestAddStock extends StockBase {

    @Parameterized.Parameters(name = "category={0} name={1}")
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {2, "FB"},
                {2, "PDD"},
                {2, "GLG"}
        });
    }

    @Parameterized.Parameter
    public Integer category;
    @Parameterized.Parameter(1)
    public String name;

    @Test
    public void 添加关注(){
        given().spec(requestSpecification)
                .formParam("category", category)
                .formParam("symbol", name)
                .when().log().all().post("https://101.201.62.20:443/v4/stock/portfolio/addstock.json")
                .then().log().all()
                .statusCode(200)
        ;


        given().spec(requestSpecification)
                .queryParam("type", "6")
                .queryParam("size", "10000")
                .queryParam("category", "2")
                .when().log().all().get("https://101.201.62.20:443/v4/stock/portfolio/stocks.json")
                .then().log().all()
                .statusCode(200)
                .body("stocks.code", hasItems(name))
        ;


    }

    @Test
    public void 取消关注(){
        given().spec(requestSpecification)
                .queryParam("symbol", name)
                .when().log().all().post("https://101.201.62.20:443/v4/stock/portfolio/delstock.json?_t=1GENYMOTION66adefb1e7e6e9882dc08ac85ab792b3.5708953570.1532745299823.1532762170703&amp;_s=bbc123")
                .then().log().all()
                .statusCode(200)
        ;

        given().spec(requestSpecification)
                .queryParam("type", "6")
                .queryParam("size", "10000")
                .queryParam("category", category)
                .when().log().all().get("https://101.201.62.20:443/v4/stock/portfolio/stocks.json")
                .then().log().all()
                .statusCode(200)
                .body("stocks.code", not(hasItems(name)))
        ;
    }
}




