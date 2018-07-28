package com.testerhome.api.junt;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Children extends Base{
    @BeforeClass
    public static void beforeClassChildren(){
        System.out.println("com.testerhome.api.junt.Children BeforeClass");
    }
    @AfterClass
    public static void afterClassChildren(){
        System.out.println("com.testerhome.api.junt.Children AfterClass");
    }

    @Before
    public void setupChildren(){
        System.out.println("setupChildren");
    }
    @Test
    @Category(Stage.class)
    public void demo1Children(){
        System.out.println("demo1Children");
    }

    @Test
    @Ignore("just for show")
    public void demo0Children(){
        System.out.println("demoChildren");
    }

    @Test
    @Category(Prod.class)
    public void demo2Children(){
        System.out.println("demo2Children");
    }

}
