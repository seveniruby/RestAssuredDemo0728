package com.testerhome.api.junt;

import org.junit.*;

public class Base {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("com.testerhome.api.junt.Base BeforeClass");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("com.testerhome.api.junt.Base AfterClass");
    }

    @Before
    public void setup(){
        System.out.println("setup");
    }

    @Test
    public void demo1(){
        System.out.println("demo1");
    }

    @Test
    public void demo0(){
        System.out.println("demo");
    }

    @Test
    public void demo2(){
        System.out.println("demo2");
    }

}
