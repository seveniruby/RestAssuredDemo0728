package com.testerhome.api.xueqiu.stock;

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
public class TestStocks extends StockBase{

    @Parameterized.Parameters(name = "category={0} type={1} size={2}")
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][]{
//                {2, 1, 10000},
//                {2, 1, 0},
//                {2, 1, 1},
//                {2, 1, 5},
//                {2, 1, 200},
                {1, 1, 2}
        });
    }

    @Parameterized.Parameter
    public Integer category;
    @Parameterized.Parameter(1)
    public Integer type;
    @Parameterized.Parameter(2)
    public Integer size;



    @Test
    public void demo(){
        useRelaxedHTTPSValidation();
        //RestAssured.proxy("127.0.0.1", 8080);
        given().spec(requestSpecification)
                .queryParam("category", category)
                .queryParam("size", size)
                .queryParam("type", type)
        .when()
                .log().all()
                .get("https://101.201.62.20:443/v4/stock/portfolio/stocks.json")
        .then()
                .log().all()
                .statusCode(200)
                .body("stocks.size()", lessThanOrEqualTo(size+1))
        ;
    }
}
