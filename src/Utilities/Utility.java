package Utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    //This method will click on element
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    // This method will send text to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys();
    }

    //This Method will get text from element
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    //Select By Value from dropdown
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }
    // Select By index from dropDown
    public void selectByIndexFromDown(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }
    // Select by Visible text from Dropdown
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        //Create the object of select Class
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    /**
     * This method will have click action on mousehover element
     */
    public void clickMouseHoverOnElements(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    //This method will verify the text
    public void verifyText( String expectedText, String actualText) {
        Assert.assertEquals( expectedText, actualText);
}
}
