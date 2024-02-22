
package com.herokuapp.uitests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {
    @Test
    public void switchToFrame() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-bottom");

        String bodyText = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(bodyText, "BOTTOM", "Wrong frame");

        driver.switchTo().defaultContent();
        Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 2);


    }

        @Test(dataProvider = "frameNames")
    public void switchToFrame(String frameName) {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("/html/frameset/frame[1]");
        String bodyText1 = driver.findElement(By.xpath("/html/body")).getText();
        Assert.assertEquals(bodyText1, "left", "Wrong frame");

        driver.switchTo().defaultContent();
         Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 1);

        driver.switchTo().frame("/html/frameset/frame[2]");
        String bodyText2 = driver.findElement(By.xpath("//*[@id=\"content\"]")).getText();
        Assert.assertEquals(bodyText2, "MIDDLE", "Wrong frame");

        driver.switchTo().defaultContent();
         Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 1);

        driver.switchTo().frame("/html/frameset/frame[3]");
        String bodyText3 = driver.findElement(By.xpath("/html/body")).getText();
        Assert.assertEquals(bodyText3, "RIGHT", "Wrong frame");


        driver.switchTo().defaultContent();
        Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 1);


    }
}


