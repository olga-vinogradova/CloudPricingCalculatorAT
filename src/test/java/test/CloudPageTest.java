package test;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.cloud.CloudMainPage;
import page.cloud.CloudPricingPage;
import page.cloud.SearchResultPage;
import page.emailGenerator.EmailGeneratorPage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CloudPageTest extends CommonConditions{
    private final String cloudPageUrl = "https://cloud.google.com/";
    private final String emailGeneratorURL = "https://internxt.com/temporary-email";
    private final String searchText = "Google Cloud Platform Pricing Calculator";


    @Test
    public void checkGoogleCloudPricing(){
        driver.get(cloudPageUrl);

        CloudMainPage cloudMainPage = new CloudMainPage(driver, searchText);
        cloudMainPage.searchRequest();

        SearchResultPage searchResultPage = new SearchResultPage(driver, "Google Cloud Pricing Calculator");
        searchResultPage.clickGoogleCloudPricingCalculator();


        CloudPricingPage pricingPage = new CloudPricingPage(driver);
        pricingPage.fillOutNumberOfInstances();
        pricingPage.fillOutSeries();
        pricingPage.fillOutMachine();
        pricingPage.fillCommittedUsage();
        pricingPage.fillSSD();
        pricingPage.fillLocation();
        pricingPage.enableGPU();
        //pricingPage.fillOutGPU();
        pricingPage.clickAddToEstimate();
        pricingPage.clickEmailEstimateButton();


        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(emailGeneratorURL);

        EmailGeneratorPage emailGeneratorPage = new EmailGeneratorPage(driver);
        emailGeneratorPage.clickCopyEmailButton();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        pricingPage.inputEmail();
        pricingPage.sendEmail();

        driver.switchTo().window(tabs.get(1));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        emailGeneratorPage.openReceivedEmail();
        String priceInEmail = emailGeneratorPage.findPriceInEmail();


        driver.switchTo().window(tabs.get(0));
        String priceOnCloudWebPage = pricingPage.findPriceOnCloudPage();
        Assert.assertTrue(priceOnCloudWebPage.contains(priceInEmail));
    }


}
