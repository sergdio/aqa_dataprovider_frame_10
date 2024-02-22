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

//        public void testJSConfirm()    {
//            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//
//            //String str = "Student";
//
//            WebElement promptButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
//            promptButton.click();
//
//            Alert alert = driver.switchTo().alert();
//            alert.sendKeys(str);
//            alert.accept();
//
//            String actualResult = driver.findElement(By.id("//*[@id=\"result\"]")).getText();
//            Assert.assertEquals(actualResult, "You clicked: " + str);



    }
}
