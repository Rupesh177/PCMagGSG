package page_objects;


import framework.ParentPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class PCMag_Home_Page extends ParentPage {

    public WebDriver driver;
    public MenuListSubPage obj_MenuList_SubPage;


    @FindBy(xpath = "//img[@alt='PCMag Nav Logo']")
    WebElement pcMag;

    @FindBy(xpath = "//button[text()='Accept All']")
    WebElement cookie_accept;

    @FindBy(xpath = "//span[normalize-space()='Antivirus']")
    WebElement antivirus_header;

    @FindBy(xpath = "//p[@class='leading-normal text-md']")
    WebElement antivirus_Article;

    By antivirus_Article_block= By.xpath("//div[@class='hide-ten commerce-00wzecNfK1lCITGtjuBTTms']/descendant::span[@class='border-b flex flex-wrap md:flex-nowrap border-gray-lighter pt-8 pb-8 pb-3 block justify-between items-center']");


    public PCMag_Home_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        obj_MenuList_SubPage = new MenuListSubPage(driver);
        PageFactory.initElements(driver, this);
    }

    public void Verify_PC_Home_Page() {
        verify_Element_displayed(pcMag);
        Assert.assertEquals(true, getPageTitle().contains("The Latest Technology Product Reviews, News"));
    }

    public void setCookie_accept() {
        verify_Element_displayed(cookie_accept);
        clickUsingJScript(cookie_accept);
    }

    public void openMainMenu(String mainCategory){
        WebElement best_Products= setXpath(mainCategory);
        obj_MenuList_SubPage.selectCategory(best_Products);
    }

    public void openSubMenu(String subCategory){
        WebElement software_services= setXpath(subCategory);
        obj_MenuList_SubPage.selectCategory(software_services);
    }

    public void clickOnBestAntivirus(String finalOption){
        WebElement final_Value= setXpath(finalOption);
        verify_Element_displayed(final_Value);
        clickUsingJScript(final_Value);
    }

    public void headerCheckWithName(){
        obj_MenuList_SubPage.headerCheck(antivirus_header, "Antivirus");
    }

    public void articleCheck(){
        obj_MenuList_SubPage.articleCheck(antivirus_Article);
    }

    public void articleBlockCheck(){
        verify_Element_displayed(antivirus_Article_block);
        int count= driver.findElements(antivirus_Article_block).size();
        Assert.assertEquals(count,10);
    }

}
