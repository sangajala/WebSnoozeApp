package com.snooze;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import com.web.snooze.*;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;


public class StepDef {
    static WebDriver driver;
    Homepage hpage;

    @Before
    public void StartBrowser() throws MalformedURLException, InterruptedException {
        try {

            BrowserFactory.StartBrowser("firefox", "http://tvishitech.com/webdev/snooze/index.php");
            driver = BrowserFactory.driver;
        } catch (Exception e) {
            e.printStackTrace();
        }
        hpage = new Homepage();
    }

    @After
    public void closeBrowser() throws MalformedURLException, InterruptedException {

        driver.quit();

        //.QuitBrowser();

    }

    @Given("^User is in the home page$")
    public void User_is_in_the_home_page() {
        Assert.assertTrue(Utils.isTextPresent("Sign in"));
    }


    @When("^User clicks the link signin$")
    public void User_clicks_the_link_signin() {
        hpage.clicksignin();
    }

    @And("^Enters '(.*)' as username$")
    public void Enters_admin_as_username(String uname) {
        hpage.enterusername(uname);
    }

    @And("^Enters '(.*)' as password$")
    public void Enters_admin_as_password(String pwd) {
        hpage.enterpwd(pwd);
    }

    @And("^clicks the signin button$")
    public void clicks_the_signin_button() {
        hpage.clicksigninbutton();
        Utils.sleep(10);
    }

    @Then("^User can see the superadmin homepage$")
    public void User_can_see_the_superadmin_homepage(){
      Assert.assertEquals("super admin", driver.findElement(By.cssSelector("span.username")).getText());
    }

    @Then("^User sees the '(.*)' as errormessage$")
    public void User_sees_the_Error_as_errormessage(String error) {
        Assert.assertEquals(error,driver.findElement(By.id("error")).getText());
    }
}
