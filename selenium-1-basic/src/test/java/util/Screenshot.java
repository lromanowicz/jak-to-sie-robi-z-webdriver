package util;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class Screenshot {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "etc/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable throwable, Description description) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile,
                        new File("failshot_"
                                + description.getClassName()
                                + "_" + description.getMethodName()
                                + ".png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        @Override
        protected void finished(Description description) {
            driver.quit();
        }
    };

    @Test
    public void OnError() {
        driver.get("http://the-internet.herokuapp.com");
        assertThat(false, is(true));
    }


}