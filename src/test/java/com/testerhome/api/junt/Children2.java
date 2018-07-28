package com.testerhome.api.junt;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Children2 extends Base{
    @BeforeClass
    public static void beforeClassChildren2(){
        System.out.println("com.testerhome.api.junt.Children2 BeforeClass");
    }
    @AfterClass
    public static void afterClassChildren2(){
        System.out.println("com.testerhome.api.junt.Children2 AfterClass");
    }

    @Before
    public void setupChildren2(){
        System.out.println("setupChildren2");
    }
    @Test
    public void demo1Children2(){
        System.out.println("demo1Children2");
        assertThat(1, equalTo(2));
    }

    @Test
    public void demo0Children2(){
        System.out.println("demoChildren2");
    }

    @Test
    @Category(Stage.class)
    public void demo2Children2(){
        System.out.println("demo2Children2");
    }

}
