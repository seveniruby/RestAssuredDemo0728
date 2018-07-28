package com.testerhome.api.junt;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.ExcludeCategory(Stage.class)
@Suite.SuiteClasses({
        Children.class,
        Children2.class
})
public class AllSuite2 {
}
