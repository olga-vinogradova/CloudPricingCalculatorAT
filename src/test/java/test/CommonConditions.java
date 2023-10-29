package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.TestListener;

import java.io.IOException;
import java.util.Properties;

@Listeners({TestListener.class})
public class CommonConditions {

    public WebDriver driver;

    @BeforeMethod()
    public void setUp() throws IOException {
        //System.setProperty("browser","edge");
        //System.setProperty("browser","chrome");
        //driver = DriverSingleton.getDriver();

        String browserName = System.getProperty("browser", "chrome"); // default browser
        String propertiesFileName = browserName + ".properties";
        Properties browserProperties = new Properties();
        browserProperties.load(ClassLoader.getSystemResourceAsStream(propertiesFileName));

        driver = DriverSingleton.getDriver(browserProperties);
    }
    @AfterMethod(alwaysRun = true)
    public void stopBrowser(){
        DriverSingleton.closeDriver();
        }
    }

