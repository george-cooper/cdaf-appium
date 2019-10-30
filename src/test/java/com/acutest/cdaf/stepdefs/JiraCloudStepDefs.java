package com.acutest.cdaf.stepdefs;

import com.acutest.cdaf.TestConfiguration;
import com.acutest.cdaf.jiraapi.IssueInstance;
import com.fasterxml.jackson.databind.JsonNode;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JiraCloudStepDefs {

    private static Logger logger = LogManager.getLogger(JiraCloudStepDefs.class);
    MobileDriver driver = AppCapabilities.getDriver();
    private WebDriverWait wait;

    @Given("a user is logged into the ServCo application as user {string} on a mobile device or tablet")
    public void aUserIsLoggedIntoTheServCoApplicationAsUserUsernameOnAMobileDeviceOrTablet(String username) {
        WebElement loginButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.Button"));
        loginButton.click();
        wait = new WebDriverWait(driver, 2000);

        WebElement loginWithEmail = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[2]"));
        loginWithEmail.click();
        String emailLocator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[3]/android.view.View[2]/android.view.View[1]/android.widget.EditText";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailLocator)));
        WebElement email = driver.findElement(By.xpath(emailLocator));
        email.sendKeys(username);
        WebElement loginSubmit = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[3]/android.view.View[2]/android.view.View[2]/android.widget.Button"));
        loginSubmit.click();

        String passwordLocator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[3]/android.view.View[2]/android.view.View[2]/android.widget.EditText";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passwordLocator)));
        WebElement password = driver.findElement(By.xpath(passwordLocator));
        password.sendKeys(TestConfiguration.getProperty("georgeTest"));
        WebElement loginSubmit2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[3]/android.view.View[2]/android.view.View[4]/android.widget.Button"));
        loginSubmit2.click();
    }

    @And("the project {string} is selected")
    public void theProjectProjectIsSelected(String project2) {
        String selectProject = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectProject)));
        //WebElement project = driver.findElement(By.xpath(selectProject));
        MobileElement elementOne =(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='" + project2 + "']");
        elementOne.click();
    }

    @And("the ticket {string} is selected")
    public void theTicketTicketIsSelected(String ticket) {
        String issues = "//android.widget.FrameLayout[@content-desc=\"Issues\"]/android.widget.ImageView";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(issues)));
        WebElement issuesButton = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Issues\"]/android.widget.ImageView"));
        issuesButton.click();
        String searchIssue = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchIssue)));
        WebElement search = driver.findElement(By.xpath(searchIssue));
        search.click();
        String waitSearch = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.EditText";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(waitSearch)));
        WebElement searchIssue2 = driver.findElement(By.xpath(waitSearch));
        searchIssue2.sendKeys(ticket);
    }

    @When("the user transitions its status to {string}")
    public void theUserTransitionsItsStatusToStatus(String newStatus) {
        String selectIssue = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup\n";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectIssue)));
        WebElement issue = driver.findElement(By.xpath(selectIssue));
        issue.click();
        String issueStatus = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(issueStatus)));
        WebElement status = driver.findElement(By.xpath(issueStatus));
        status.click();
        String done = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.TextView";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(done)));
        WebElement selectDone = driver.findElementByXPath("//android.widget.TextView[@text='" + newStatus + "']");
        selectDone.click();
    }

    @Then("the issue with id {string} has a status of {string} when checked through the API")
    public void theIssueWithIdTicketHasAStatusOfStatusWhenCheckedThroughTheAPI(String ticket, String status) throws Exception {
        IssueInstance instance = new IssueInstance(ticket);
        instance.loadIssue();
        JsonNode json = instance.getFieldsNode();
        String actualStatus = json.path("status").path("name").asText();
        boolean a = actualStatus.equals(status);
        Assert.assertTrue("The actual status: " + actualStatus + ". Doesn't match the expected status: "
                + status + ".", a);
    }
}
