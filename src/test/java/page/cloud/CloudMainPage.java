package page.cloud;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CloudMainPage {
    public WebDriver driver;
    private String searchText;

    public CloudMainPage(WebDriver driver, String searchText) {
        this.driver = driver;
        this.searchText = searchText;
    }

    private By searchIcon = By.xpath("//input[@name='q']");

    public WebElement getSearchIcon() {
        return driver.findElement(searchIcon);
    }

    public void searchRequest() {
        getSearchIcon().click();
        getSearchIcon().sendKeys(searchText);
        getSearchIcon().submit();
    }
}

