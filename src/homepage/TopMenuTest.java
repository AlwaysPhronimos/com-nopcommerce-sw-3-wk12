package homepage;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenuTest extends Utility {

    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //create class "TopMenuTest"
    public void selectMenu(String menu) {
        // 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
        List<WebElement> selectMenu = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/child::li"));
        for (WebElement element : selectMenu) {
            if (element.getText().equalsIgnoreCase(menu)) {
                element.click();
                break;
            }
        }
    }

    @Test
    // 1.2 This method should click on the menu whatever name is passed as parameter.
    /*1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
    select the Menu and click on it and verify the page navigation.*/
    public void verifyPageNavigation() {
        selectMenu("Computers");
        verifyText("Computers", getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]")));
        selectMenu("Electronics");
        verifyText("Electronics", getTextFromElement(By.xpath("(//a[normalize-space()='Electronics'])[1]")));
        selectMenu("Apparel");
        verifyText("Apparel", getTextFromElement(By.xpath("(//a[normalize-space()='Apparel'])[1]")));
        selectMenu("Digital downloads");
        verifyText("Digital downloads", getTextFromElement(By.xpath("(//a[normalize-space()='Digital downloads'])[1]")));
        selectMenu("Books");
        verifyText("Books", getTextFromElement(By.xpath("(//a[normalize-space()='Books'])[1]")));
        selectMenu("Jewelry");
        verifyText("Jewelry", getTextFromElement(By.xpath("(//a[normalize-space()='Jewelry'])[1]")));
        selectMenu("Gift Cards");
        verifyText("Gift Cards", getTextFromElement(By.xpath("(//a[normalize-space()='Gift Cards'])[1]")));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

