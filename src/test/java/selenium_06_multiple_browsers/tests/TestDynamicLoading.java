package selenium_06_multiple_browsers.tests;

import org.junit.Before;
import org.junit.Test;
import selenium_06_multiple_browsers.pageobjects.DynamicLoading;
import selenium_06_multiple_browsers.tests.Base;

import static org.junit.Assert.assertTrue;

public class TestDynamicLoading extends Base {

    private DynamicLoading dynamicLoading;

    @Before
    public void setUp() {
        dynamicLoading = new DynamicLoading(driver);
    }

    @Test
    public void hiddenElementLoads() {
        dynamicLoading.loadExample("1");
        assertTrue("finish text didn't display after loading",
                dynamicLoading.isFinishTextDisplayed());
    }

    @Test
    public void elementAppears() {
        dynamicLoading.loadExample("2");
        assertTrue("finish text didn't render after loading",
                dynamicLoading.isFinishTextTextPresent());
    }

}