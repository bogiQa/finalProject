package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Home_Page extends BasePage {
    WebDriverWait wait;

    public Home_Page(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @FindBy(css = "[data-testid='header-booking-logo']")
    WebElement headerLogo;
    @FindBy(css = "[name='ss']")
    WebElement locationField;

    @FindBy(css = "[data-testid='searchbox-dates-container']")
    WebElement datePickerBtn;

    @FindBy(css = ".b80d5adb18")
    List<WebElement> datePicker;

    @FindBy(css = "[type='submit']")
    WebElement searchBtn;

    @FindBy(css = "h1")
    WebElement searchResults;

    @FindBy(css = ".ab6cf2edce.hero-banner-wrapper.b36dba3aaa.a2893870c6")
    WebElement popupScreen;
    @FindBy(css = ".fcd9eec8fb.dbed623b69")
    WebElement geniusLogo;

    @FindBy(css = "[aria-label='Dismiss sign-in info.']")
    WebElement exitLogo;

    @FindBy(css = "[data-testid='occupancy-config']")
    WebElement personBtn;

    @FindBy(css = ".fcd9eec8fb.bf9a32efa5")
    List<WebElement> personSelect;

    public void logoText() {
        Assert.assertTrue(headerLogo.isDisplayed());
        System.out.println("Logo header checked!");
    }
    public void searchField() {
        click(locationField);
    }
    public void inputLocation(String locationText) throws Exception {
        click(locationField);
        typeText(locationField, locationText, "Location is: " + locationText);
    }
    public void dateButton() {
        click(datePickerBtn);
    }
    public void dateSelect() throws InterruptedException {
        datePicker.get(31).click();
        datePicker.get(42).click();
    }
    public void newDate(){
        datePicker.get(26).click();
        datePicker.get(40).click();
    }
    public void changeDate(){
        datePicker.get(16).click();
        datePicker.get(33).click();
    }
    public void chicagoDates(){
        datePicker.get(10).click();
        datePicker.get(28).click();
    }
    public void newYorkDates(){
        datePicker.get(5).click();
        datePicker.get(22).click();
    }
    public void searchButton() {
        click(searchBtn);
    }
    public void results() {
        wait.until(ExpectedConditions.visibilityOf(searchResults));
        Assert.assertTrue(searchResults.isDisplayed());
        System.out.println("Search results checked!");
    }
    public void popUpScreen() {
        if (geniusLogo.isDisplayed()) {
            click(exitLogo);
            System.out.println("Pop-up screen removed!");
        }
    }
    public void personButton() {
        click(personBtn);
    }
    public void personReduction() {
        personSelect.get(3).click();
    }
    public void personAdd(){
        personSelect.get(4).click();
    }
}

