package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page_objects.PCMag_Home_Page;

import java.io.InputStream;
import java.util.Properties;

public class ParentScenario {

    public WebDriver driver;
    protected static PCMag_Home_Page obj_Home_Page;
    protected Properties configProp = new Properties();
    protected InputStream in = this.getClass().getClassLoader().getResourceAsStream("data_set.properties");


    public void Before_Setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable--notifications");
        chromeOptions.addArguments("--remote-allow-origins=*");
//    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        obj_Home_Page = new PCMag_Home_Page(driver);
    }

    public void Launch_URL(String URL) {
        driver.get(URL);
    }

    public void Verify_Browser_Launched() {
        String result = driver.toString();
        Assert.assertFalse("Browser not launched", result.isEmpty());
    }

    public void closeBrowser() {
            obj_Home_Page.driver.close();
            obj_Home_Page.driver.quit();
            obj_Home_Page = null;
    }

}

