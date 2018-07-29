package com.testerhome.api.xueqiu.stock0729;

import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class Stocks extends Login {

    @Parameterized.Parameters(name="{4}")
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {2, 1, 10000, "SZ", "所有"}, //all
                {2, 5, 10000, "SZ", "沪深"}, //沪深
                {2, 6, 10000, "NYSE", "美股"}, //美股
                {2, 7, 10000, "HK", "港股"}, //港股
                {2, 7, 0, "HK", "列表为0"}, //港股
                {2, 7, 1, "HK", "列表为1"}, //港股
                {2, 7, 5, "HK", "列表为5"}, //港股
        });
    }


    @Parameterized.Parameter
    public Integer category;
    @Parameterized.Parameter(1)
    public Integer type;
    @Parameterized.Parameter(2)
    public Integer size;

    @Parameterized.Parameter(3)
    public String exchange;

    @Parameterized.Parameter(4)
    public String testcaseName;


    @Test
    public void all(){
        useRelaxedHTTPSValidation();
        given().spec(requestSpecification)
                .queryParam("size", size)
                .queryParam("category", category)
                .queryParam("type", type)
                .when().log().all().get("https://101.201.62.20:443/v4/stock/portfolio/stocks.json")
                .then().log().all()
                .statusCode(200)
                .body("stocks.size()", lessThanOrEqualTo(size))
                .body("stocks.exchange", hasItems(exchange))
        ;
    }
}
