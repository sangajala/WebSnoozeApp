package com.web.snooze;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


    public abstract class BrowserFactory {
        public static WebDriver driver;

        public static WebDriver StartBrowser(String Browser, String URL) throws MalformedURLException, InterruptedException {
            if (driver == null) {
                driver = startRemoteWebBrowser(Browser, URL);
            }
            driver.manage().window().maximize();
            return driver;
        }

        public static WebDriver getDriver() {
            return driver;
        }

        public static void QuitBrowser() {
//		getDriver().quit();
            //  WebDriver d = getDriver();
            driver = null;
        }

        protected static WebDriver startRemoteWebBrowser(String browser, String URL) {

            if (true) {
                try {
                    DesiredCapabilities caps = DesiredCapabilities.firefox();
                    caps.setCapability("platform", "Windows 8.1");
                    caps.setCapability("version", "30");
                    driver = new RemoteWebDriver(
                            new URL("http://bharaj05:64ff29d2-e7de-404b-889e-6f3fc7ca86dd@ondemand.saucelabs.com:80/wd/hub"),
                            caps);


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("inside exception");
                }
            } else {

                try {
                    if (browser.equalsIgnoreCase("Firefox")) {
                        FirefoxProfile firefoxprofile = new FirefoxProfile();
                        firefoxprofile.setAssumeUntrustedCertificateIssuer(true);
                        firefoxprofile.setAcceptUntrustedCertificates(true);
                        driver = new FirefoxDriver(firefoxprofile);
                        //driver.get("https://google.com");
                        //driver=new FirefoxDriver();

                    } else if (browser.equalsIgnoreCase("chrome")) {
                        //System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
                        //  driver=new ChromeDriver();
                        System.setProperty("webdriver.chrome.driver", "\\Users\\bijojosephbj\\Desktop\\Automation\\Chromeexe/\\chromedriver");
                        driver = new ChromeDriver();
                    } else
                        throw new RuntimeException("Browser give " + browser + " did not load..");
                } catch (Exception e) {
                    throw new RuntimeException("Browser give " + browser + " did not load..");
                }
            }
            driver.get(URL);
            return driver;
        }
    }

