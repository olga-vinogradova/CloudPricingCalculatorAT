package page.cloud;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.AbstractPage;

import java.util.concurrent.TimeUnit;


public class CloudPricingPage extends AbstractPage {

    public CloudPricingPage(WebDriver driver) {
        super(driver);
    }

    private By numberOfInstancesInput = By.xpath ("//input[@ng-model='listingCtrl.computeServer.quantity']");
    private By seriesDropdown = By.xpath("//md-select[@name='series']/parent::md-input-container");
    private By seriesSelectOption = By.xpath(  "//md-option[@value='n1']/div");
    private By machineTypeDropdown = By.xpath("//label[text()='Machine type']/parent::md-input-container");
    private By machineTypeSelectOption = By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");
    private By addGPUsCheckbox = By.xpath("//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']/div[@md-ink-ripple]");
    private By gpuTypeDropdown = By.xpath( "//md-select[@placeholder='GPU type']");
    private By gpuTypeSelectOption = By.xpath("//md-option[@value='NVIDIA_TESLA_V100']");
    private By numberOfGPUsDropdown = By.xpath("//md-select[@placeholder='Number of GPUs']");
    private By numberOfGPUSelectOption = By.xpath("//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]' and @value ='1']");
    private By localSSDDropdown = By.xpath("//md-select[@placeholder='Local SSD']");
    private By localSSDSelectOption = By.xpath("//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer'][@value='2']");
    private By datacenterLocationDropdown = By.xpath("//md-select[@placeholder='Datacenter location']");
    private By datacenterLocationSelectOption = By.xpath("//md-option[@value='europe-west3']");
    private By committedUsageDropdown = By.xpath("//md-select[@id='select_139'][@placeholder='Committed usage']");
    private By committedUsageSelectOption = By.xpath("//md-option[@id='select_option_137'][@ng-value='1'][@value='1']");
    private By addToEstimateButton = By.xpath("//button[contains(text(), 'Add to Estimate')]");
    private By emailEstimateButton = By.xpath("//button[@aria-label='Print' and @title='Email Estimate']");
    private By EmailInputField = By.xpath("//input[@type='email']");
    private By SendEmailButton = By.xpath("//button[contains(text(), 'Send Email')]");
    private By PriceOnCloudPage = By.xpath("//*[contains(text(),'Total Estimated Cost')]");


    public WebElement getNumberOfInstancesInput() {
        return driver.findElement(numberOfInstancesInput);
    }
    public WebElement getSeriesDropdown() {
        return driver.findElement(seriesDropdown);
    }
    public WebElement getSeriesSelectOption() {
        return driver.findElement(seriesSelectOption);
    }
    public WebElement getMachineTypeDropdown() {
        return driver.findElement(machineTypeDropdown);
    }
    public WebElement getMachineTypeSelectOption() {
        return driver.findElement(machineTypeSelectOption);
    }
    public WebElement getAddGPUsCheckbox() {
        return driver.findElement(addGPUsCheckbox);
    }
    public WebElement getGpuTypeDropdown() {
        return driver.findElement(gpuTypeDropdown);
    }
    public WebElement getGpuTypeSelectOption() {
        return driver.findElement(gpuTypeSelectOption);
    }
    public WebElement getNumberOfGPUsDropdown() {
        return driver.findElement(numberOfGPUsDropdown);
    }
    public WebElement getNumberOfGPUSelectOption() {
        return driver.findElement(numberOfGPUSelectOption);
    }
    public WebElement getLocalSSDDropdown() {
        return driver.findElement(localSSDDropdown);
    }
    public WebElement getLocalSSDSelectOption() {
        return driver.findElement(localSSDSelectOption);
    }
    public WebElement getDatacenterLocationDropdown() {
        return driver.findElement(datacenterLocationDropdown);
    }
    public WebElement getDatacenterLocationSelectOption() {
        return driver.findElement(datacenterLocationSelectOption);
    }
    public WebElement getCommittedUsageDropdown() {
        return driver.findElement(committedUsageDropdown);
    }
    public WebElement getCommittedUsageSelectOption() {
        return driver.findElement(committedUsageSelectOption);
    }
    public WebElement getAddToEstimateButton() {
        return driver.findElement(addToEstimateButton);
    }
    public WebElement getEmailEstimateButton(){return driver.findElement(emailEstimateButton);}
    public WebElement getEmailInputField(){return  driver.findElement(EmailInputField);}
    public WebElement getSendEmailButton(){return driver.findElement(SendEmailButton);}
    public WebElement getPriceOnCloudPage(){return driver.findElement(PriceOnCloudPage);}

    public void fillOutNumberOfInstances() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'goog_')]")));
        driver.switchTo().frame("myFrame");
        WebElement instancesInput = getNumberOfInstancesInput();
        waitToClickTheElement(instancesInput).sendKeys("4");
    }

    public void fillOutSeries() {
        waitToClickTheElement(getSeriesDropdown()).click();
        waitToClickTheElement(getSeriesSelectOption()).click();
    }

    public void fillOutMachine() {
        waitToClickTheElement(getMachineTypeDropdown()).click();
        waitToClickTheElement(getMachineTypeSelectOption()).click();
    }
    public void enableGPU(){
        waitToClickTheElement(getAddGPUsCheckbox()).click();
    }

    public void fillOutGPU() {
        waitToClickTheElement(getGpuTypeDropdown()).click();
        waitToClickTheElement(getGpuTypeSelectOption()).click();
        waitToClickTheElement(getNumberOfGPUsDropdown()).click();
        waitToClickTheElement(getNumberOfGPUSelectOption()).click();
    }

    public void fillSSD() {
        waitToClickTheElement(getLocalSSDDropdown()).click();
        waitToClickTheElement(getLocalSSDSelectOption()).click();
    }

    public void fillLocation() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        waitToClickTheElement(getDatacenterLocationDropdown()).click();
        waitToClickTheElement(getDatacenterLocationSelectOption()).click();
    }

    public void fillCommittedUsage() {
        waitToClickTheElement(getCommittedUsageDropdown()).click();
        waitToClickTheElement(getCommittedUsageSelectOption()).click();
    }

    public void clickAddToEstimate() {
        waitToClickTheElement(getAddToEstimateButton()).click();
    }
    public void clickEmailEstimateButton() {
        waitToClickTheElement(getEmailEstimateButton()).click();
    }

    public void inputEmail(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'goog_')]")));
        driver.switchTo().frame("myFrame");
        getEmailInputField().click();
        getEmailInputField().sendKeys(Keys.CONTROL + "v");
    }
    public void sendEmail(){
        getSendEmailButton().click();
    }
    public String findPriceOnCloudPage(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'goog_')]")));
        driver.switchTo().frame("myFrame");
        return getPriceOnCloudPage().getText();
    }
}
