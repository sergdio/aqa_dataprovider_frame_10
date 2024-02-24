package com.herokuapp.uitests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest {
    @Test
    public void testJSPrompt() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        String str = "Student";

        WebElement promptButton = driver.findElement(By.xpath("//button[contains(text(),'JS Prompt')]"));
        promptButton.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(str);
        alert.accept();

        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "You entered: " + str);

        @Test
        public void testJSConfirm() {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement promptButton1 = driver.findElement(By.xpath("//button[contains(text(),'JS Confirm')]"));
        promptButton1.click();

        Alert alert1 = driver.switchTo().alert();
        //alert1.sendKeys(str);
        alert1.accept();

        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "You clicked:  " + "ОК");

    }
}
