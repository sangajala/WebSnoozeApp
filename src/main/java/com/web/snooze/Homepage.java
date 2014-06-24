package com.web.snooze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Homepage {
    WebDriver driver = BrowserFactory.getDriver();

    public void clicksignin() {
        driver.findElement(By.linkText("Sign in")).click();
    }

    public void enterusername(String uname) {
        driver.findElement((By.id("adminname"))).sendKeys(uname);
    }

    public void enterpwd(String pwd) {
        driver.findElement((By.id("password"))).sendKeys(pwd);
    }

    public void clicksigninbutton() {
        driver.findElement(By.id("loginbt")).click();
    }
}
