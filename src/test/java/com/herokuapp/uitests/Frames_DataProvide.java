package com.herokuapp.uitests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Frames_DataProvide extends BaseTest {

    @Test(dataProvider = "frameNames")
    public void switchToFrame(String frameName) {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        if (!frameName.equals("frame-bottom")) {
            driver.switchTo().frame(frameName);

            String bodyText = driver.findElement(By.xpath("//body")).getText();
            Assert.assertNotEquals(bodyText, "", "Frame content is empty for " + frameName);

            driver.switchTo().defaultContent();
        } else {
            // Handle BOTTOM frame separately
            driver.switchTo().frame("frame-bottom");

            String bodyText = driver.findElement(By.xpath("//body")).getText();
            Assert.assertEquals(bodyText, "BOTTOM", "Wrong frame for BOTTOM");

            driver.switchTo().defaultContent();
            Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 2);
        }
    }

    @DataProvider(name = "frameNames")
    public Object[][] getFrameNames() {
        return new Object[][]{
                {"frame-left"},
                {"frame-middle"},
                {"frame-right"}

                // Add more frames as needed
        };
    }
}