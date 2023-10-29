package page.emailGenerator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.AbstractPage;


public class EmailGeneratorPage extends AbstractPage {

    public EmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    private By copyEmailButton = By.xpath("//button[p='Copy email']");
    private By openEmail = By.xpath("//p[contains(., 'New Compute User')]");
    private By priceInEmail = By.xpath("//td/*[starts-with(text(),'USD')]");
    public WebElement getEmailButton() {
        return driver.findElement(copyEmailButton);
    }
    public WebElement getOpenEmail(){return driver.findElement(openEmail);}
    public WebElement getPriceFromEmail(){return driver.findElement(priceInEmail);}

    public void clickCopyEmailButton() {
        WebElement copyEmailButton = getEmailButton();
        waitToClickTheElement(copyEmailButton).click();
    }
    public void openReceivedEmail(){
        WebElement openEmail = getOpenEmail();
        waitToClickTheElement(openEmail).click();
    }
    public String findPriceInEmail(){
        return getPriceFromEmail().getText();
    }

}


