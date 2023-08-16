package Selenium_demo;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(String browser) throws Exception {
        DriverManager driverManager;
        browser = browser.toUpperCase();
        switch (browser){
            case "CHROME":{
                driverManager = new ChromeDriverManager();
            }
            break;
            case "MICROSOFT EDGE":{
                driverManager = new EdgeDriverManager();
            }
            break;
            default: throw new Exception("Browser: "+browser+" is not correct");
        }
        return driverManager;
    }
}

