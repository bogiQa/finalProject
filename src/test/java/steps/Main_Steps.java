package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages.Home_Page;
import tests.BaseTest;

public class Main_Steps extends BaseTest {
    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");

    @Before
    public void setup() throws Exception {
        init(browser);
    }

    @After
    public void tearDown() {
        if (quit.equalsIgnoreCase("yes")) {
            quit();
        }
    }
    @Given("I am on the homepage screen")
    public void iAmOnTheHomepageScreen() {
        driver.get("https://www.booking.com/");
        new Home_Page(driver).popUpScreen();
        new Home_Page(driver).logoText();
    }
    @When("I click on search field")
    public void iClickOnSearchField() {
        new Home_Page(driver).searchField();
    }
    @And("enter location {string}")
    public void enterLocation(String location) throws Exception {
        new Home_Page(driver).inputLocation(location);
    }
    @And("click on date field")
    public void clickOnDateField() {
        new Home_Page(driver).dateButton();
    }
    @And("select date for Kopaonik")
    public void selectDateForKopaonik() throws InterruptedException {
        new Home_Page(driver).dateSelect();
    }
    @And("select number of persons to one person")
    public void selectNumberOfPersonsToOnePerson() {
        new Home_Page(driver).personReduction();
    }
    @And("click on search button")
    public void clickOnSearchButton() {
        new Home_Page(driver).searchButton();
    }
    @And("click on person field")
    public void clickOnPersonField() {
        new Home_Page(driver).personButton();
    }
    @And("select number of persons to three persons")
    public void selectNumberOfPersonsToThreePersons() {
        new Home_Page(driver).personAdd();
    }
    @And("select new date")
    public void selectNewDate() {
        new Home_Page(driver).newDate();
    }
    @And("change date")
    public void changeDate() {
        new Home_Page(driver).changeDate();
    }
    @And("change date for Chicago")
    public void changeDateForChicago() {
        new Home_Page(driver).chicagoDates();
    }
    @And("change date for New York")
    public void changeDateForNewYork() {
        new Home_Page(driver).newYorkDates();
    }
    @Then("I should see my search results")
    public void iShouldSeeMySearchResults() {
        new Home_Page(driver).results();
        System.out.println("Search results have been displayed!");
    }


}
