package tests;

import Selenium_demo.DriverManager;
import Selenium_demo.DriverManagerFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {
    DriverManager driverManager;
    public WebDriver driver;

    public void init(String browser) throws Exception {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    public void quit() {
        driverManager.quitDriver();
    }
    public void openApp(String env) {
        env.toUpperCase();
        switch (env) {
            case "PROD": {
                driver.get("https://www.booking.com/");
            }
            break;

            default:
                System.out.println("Izabrani environment " + env + " je nepostojeci");
        }
    }
    public void takeScreenshot(String fileName) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("results/screenshots/"+fileName+".png"));
    }
    public void reportScreenshot(String fileName, String desc) throws IOException {
        takeScreenshot(fileName);
        Path content = Paths.get("results/screenshots/"+fileName+".png");
        try (InputStream is = Files.newInputStream(content)){
            Allure.addAttachment(desc,is);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
