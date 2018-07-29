package com.testerhome.api.xueqiu.stock0729;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.*;


@RunWith(Parameterized.class)
public class StocksAddDelete extends Login{

    @Parameterized.Parameters(name = "股票名字={0}")
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"PDD"},
                {"SOGO"},
                {"GLG"}
        });
    }

    @Parameterized.Parameter
    public String name;

    @Test
    public void delete(){
        useRelaxedHTTPSValidation();
        given().spec(requestSpecification)
                .formParam("symbol", name)
                .when().log().all().post("https://101.201.62.20:443/v4/stock/portfolio/delstock.json")
                .then().log().all()
                .statusCode(200).body("success", equalTo(true))
        ;

        given().spec(requestSpecification)
                .queryParam("size", 10000)
                .queryParam("category", 2)
                .queryParam("type", 6)
                .when().log().all().get("https://101.201.62.20:443/v4/stock/portfolio/stocks.json")
                .then().log().all()
                .statusCode(200)
                .body("stocks.size()", greaterThan(5))
                .body("stocks.code", not(hasItems(name)))
        ;

    }

    @Test
    public void add(){
        useRelaxedHTTPSValidation();
        given().spec(requestSpecification)
                .formParam("category", "2")
                .formParam("symbol", name)
                .when().log().all().post("https://101.201.62.20:443/v4/stock/portfolio/addstock.json?_t=1GENYMOTION66adefb1e7e6e9882dc08ac85ab792b3.5708953570.1532871200713.1532871458424&amp;_s=7df61d")
                .then().log().all()
                .statusCode(200).body("success", equalTo(true))
        ;

        given().spec(requestSpecification)
                .queryParam("size", 10000)
                .queryParam("category", 2)
                .queryParam("type", 6)
                .when().log().all().get("https://101.201.62.20:443/v4/stock/portfolio/stocks.json")
                .then().log().all()
                .statusCode(200)
                .body("stocks.size()", greaterThan(5))
                .body("stocks.code", hasItems(name))
        ;


    }
}
