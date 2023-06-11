package glue;

import framework.ParentScenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class Base_Step_Definition extends ParentScenario {


    @Given("I have launched browser")
    public void Verify_Browser() {
        Before_Setup();
        Verify_Browser_Launched();
    }

    @Given("I am on PCMag page")
    public void Navigate_To_NBA() throws IOException {
        configProp.load(in);
        String URL = configProp.getProperty("NEWS_URL");
        Launch_URL(URL);
        obj_Home_Page.setCookie_accept();
    }

    @Then("I should be able to see PCMag home page")
    public void Verify_App_Logo() {
        obj_Home_Page.Verify_PC_Home_Page();
    }

    @When("I select {string} from {string} section")
    public void iSelectFromSection(String subCategory, String mainCategory) {
        obj_Home_Page.openMainMenu(mainCategory);
        obj_Home_Page.openSubMenu(subCategory);
    }

    @And("I select {string} option")
    public void iSelectOption(String final_value) {
        obj_Home_Page.clickOnBestAntivirus(final_value);

    }

    @Then("I should be navigated to the {string}")
    public void navigateAndCheck(String headerName) {
        obj_Home_Page.headerCheckWithName();
        obj_Home_Page.articleCheck();
        obj_Home_Page.articleBlockCheck();
    }

    @Then("user closes the browser")
    public void After_Scenario(){
        closeBrowser();
    }
}
