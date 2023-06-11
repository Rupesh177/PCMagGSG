package page_objects;

import framework.ParentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


class MenuListSubPage extends ParentPage {

    public WebDriver driver;


    public MenuListSubPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectCategory(WebElement element){
        verify_Element_displayed(element);
        scrollIntoViewToLocate(element);
        hoverOverAnElement(element);
    }

    public void headerCheck(WebElement element, String text){
        verify_Element_displayed(element);
        Assert.assertEquals(element.getText(), text);
    }

    public void articleCheck(WebElement element){
        Assert.assertTrue(element.getText().contains("Antivirus software is critical for every PC"));
    }
}
