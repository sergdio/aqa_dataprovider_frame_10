package dataprovider.DataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTests {
    int[] arrayForTest = {1, -2, 3, -4, 5, -6};

    @Test
    public void TestArray1() {
        for (int arrayElement : arrayForTest) {
            Assert.assertTrue(arrayElement > 0);
        }
    }

    @DataProvider
    public Object[] dataProvider2() {
        return new Object[]{1, -2, 3, -4, 5, -6};
    }

    @Test(dataProvider = "dataProvider2")
    public void TestArray2(int j) {
        Assert.assertTrue(j > 0);
    }

    @DataProvider
    public Object[][] dataProvider3() {
        return new Object[][]{
                {1, "one"},
                {2, "two"},
                {3, "three"},
//                {"four", 4},
//                {5},
//                {6, "six", 7},
        };
    }

    @Test(dataProvider = "dataProvider3")
    public void TestArray3(int j, String str) {
        System.out.println(j + " " + str);
    }



    }
