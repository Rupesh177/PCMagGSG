package framework;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Utils {

    public WebDriver driver;
    public JavascriptExecutor js;
    public Actions act;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void scrollToBottom() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void scrollToUp() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)");
    }

    public void scrollIntoViewToLocate(WebElement element){
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickUsingJScript(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void clickUsingJScript(By by) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(by));
    }

    public WebElement setXpath(String text){
        WebElement menuEle = driver.findElement(By.xpath("//a[text()='"+text+"']"));
        return menuEle;
    }

    public void verify_Element_displayed(By by) {
        wait_explicit_till_element_Displayed(by, 20);
        boolean result = driver.findElement(by).isDisplayed();

        Assert.assertTrue(result);
    }

    public void verify_Element_displayed(WebElement objTest) {
        wait_explicit_till_element_Displayed(objTest, 20);
        boolean result = objTest.isDisplayed();

        Assert.assertEquals(result, true, "Element not displayed");
    }

    public void switchToiFrame(WebElement framePath) {
        setImplicitWait(10);
        driver.switchTo().frame(framePath);
    }

    public void switchToNewTab(int index) {
        setImplicitWait(10);
        ArrayList<String> originalWindow = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(originalWindow.get(index));
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public void hoverOverAnElement(WebElement ele) {
        act = new Actions(driver);
        act.moveToElement(ele).perform();
    }

    public void setImplicitWait(long seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public String get_Element_Text(By by) {
        return driver.findElement(by).getText();
    }

    public void verify_Element_Text(By by, String text) {
        String strExpected = driver.findElement(by).getText().toLowerCase().trim();
        Assert.assertEquals(strExpected, text.toLowerCase().trim(), "Element text not displayed as expected .Expected: " + text.toLowerCase() + " and Actual is : " + strExpected);
    }

    public String getAttributeVal(By by, String strAttribute) {

        String result = driver.findElement(by).getAttribute(strAttribute);
        return result;
    }

    public void wait_explicit_till_element_Displayed(By by, long seconds) {

        WebDriverWait waitnew = new WebDriverWait(driver, seconds);
        WebElement element = waitnew.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public void wait_explicit_till_element_Displayed(WebElement objTest, long seconds) {

        WebDriverWait waitnew = new WebDriverWait(driver, seconds);
        WebElement element = waitnew.until(ExpectedConditions.visibilityOf(objTest));
    }

    public void typeText(WebElement objInput, String text) {

        objInput.clear();
        objInput.sendKeys(text);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

}


