package pages;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    int maxRetries = 3;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element){
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        element.click();

    }
    public void typeText (WebElement element, String text,String log) throws Exception {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        int retryCount = 0;
        while (retryCount<maxRetries){
            try{
                webDriverWait.until(ExpectedConditions.visibilityOf(element));
                element.sendKeys(text);
                System.out.println(getCurrentTimeDate()+" Typed: " +text+" - "+ log);
                break;
            }catch (Exception e){
                retryCount++;
                System.out.println("Retry: "+retryCount+ " to type to " + log);
                if(retryCount==maxRetries){

                }
            }
        }
    }
    public String getCurrentTimeDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    public void takeScreenshot(String fileName) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("results/screenshots/"+fileName+".png"));
    }
    public void reportScreenshot(String fileName, String desc) throws IOException {
        takeScreenshot(fileName);
        Path content = Paths.get("results/screenshots/"+fileName+".png");
        try(InputStream is = Files.newInputStream(content)){
            Allure.addAttachment(desc,is);
        }catch(IOException e){
            e.printStackTrace();
            e.getMessage();
        }
    }
}

