package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Properties;

public class DriverSingleton {
    private static WebDriver driver;
    private DriverSingleton(){}
    public static WebDriver getDriver(Properties browserProperties){
       if (null == driver){
           String browserName = browserProperties.getProperty("browser");
           switch (browserName){
               case "edge": {
                   WebDriverManager.edgedriver().setup();
                   driver = new EdgeDriver();
                   break;
               }
               default: {
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
                   break;
               }
           }driver.manage().window().maximize();
       }return driver;
    }
    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
