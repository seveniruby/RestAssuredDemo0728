package com.testerhome.api.xueqiu.stock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

@RunWith(Parameterized.class)
public class TestQuote extends StockBase {

    @Parameterized.Parameters(name = "code={0} fields={1} name={3}")
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"SH600969", "name", "郴电国际"},
                {"SH600969,DWT,03933", "name", "郴电国际"},
                {"SH600969", "name,type,symbol,flag,current", "郴电国际"},
                {"SH600969,DWT,03933", "name,type,symbol,flag,current", "郴电国际"}

        });
    }

    @Parameterized.Parameter
    public String code;
    @Parameterized.Parameter(1)
    public String fields;
    @Parameterized.Parameter(2)
    public String name;



    @Test
    public void demo(){
        useRelaxedHTTPSValidation();
        given().spec(requestSpecification)
                .queryParam("fields", fields)
                .queryParam("code", code)
                .queryParam("return_hasexist", "0")
                .queryParam("isdelay", "1")
                .when().log().all().get("https://101.201.62.20:443/v4/stock/quote.json?_t=1GENYMOTION66adefb1e7e6e9882dc08ac85ab792b3.7160412574.1532745299823.1532746995324&amp;_s=13e0bc&amp;fields=name,type,symbol,flag,current,change,percentage,marketCapital,tick_size,release_date&amp;return_hasexist=0&amp;isdelay=1&amp;code=SH600969,SH600182,SH600487,CSI010,DWT,SZ002508,SH600547,SH601169,MRK,SZ000538,CSI004,SZ300012,SH600085,SZ161035,SZ000423,JNJ,SH600436,SZ002275,SZ000651,SH000001,03888,01928,02369,03933,01093")
                .then().log().all()
                .statusCode(200)
                .body("SH600969.name", equalTo(name))
        ;
    }
}
