package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class TestScripts {
    public static WebDriver driver=null;
    @Test(priority = 0, groups = {"Sanity"})
    public void setUp(){
        String path = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1, groups = {"Sanity"})
    public void navigateToWebsite(){
        driver.get("https://www.rahulshettyacademy.com/#/practice-project");
    }

    @Test(priority = 2, groups = {"Sanity"})
    public void validation(){
        boolean flag = driver.findElement(By.xpath("//span[contains(text(),'An Academy to')]")).isDisplayed();
        Assert.assertTrue(flag);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
