package computer;


import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class TestSuite extends Utility {

    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {

        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//a[@href='/computers']"));

        //1.2 Click on Desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: Z to A");

        //1.4 Verify the Product will arrange in Descending order.
        verifyText("Name: Z to A", getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]")));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//a[@href='/computers']"));

        //2.2 Click on Desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: A to Z");

        // 2.4 Click on "Add To Cart"
        clickOnElement(RelativeLocator.with(By.tagName("button")).below(By.xpath("(//button[@type='button'])[1]")));

        //2.5 Verify the Text "Build your own computer"
        verifyText("Invalid text", getTextFromElement(By.xpath("//h1[.='Build your own computer']")));

        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");

        // 2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
        Thread.sleep(2000);
        clickOnElement(By.id("product_attribute_5_12"));

        // 2.11 Verify the price "$1,475.00"
        Thread.sleep(2000);
        verifyText("Invalid price", getTextFromElement(By.id("price-value-1")));

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("Invalid text", getTextFromElement(By.xpath("//p[@class='content']")));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        clickMouseHoverOnElements(By.id("topcartlink"));
        Thread.sleep(2000);
        clickMouseHoverOnElements(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.15 Verify the message "Shopping cart"
        verifyText("Invalid text",getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart']")));

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clickOnElement(By.xpath("//td[@class='quantity']/child::input"));
        driver.findElement(By.xpath("//td[@class='quantity']/child::input")).clear();
        sendTextToElement(By.xpath("//td[@class='quantity']/child::input"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        verifyText("Invalid price", getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]")));

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyText("Invalid text", getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")));

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Smart");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Tester");
        sendTextToElement(By.id("BillingNewAddress_Email"), "testerissmart@gmail.com");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "Canada");
        sendTextToElement(By.id("BillingNewAddress_City"), "Toronto");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "3,Millcar Drive");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "3322568");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "123654789");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.id("shippingoption_1"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/descendant::a/following::button[1]"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");

        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Mr Smart Tester");
        sendTextToElement(By.id("CardNumber"), "5425233430109903");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "04");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2028");
        sendTextToElement(By.id("CardCode"), "321");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is “Credit Card”
        verifyText("Invalid method", getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']")));

        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyText("Invalid method", getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']")));

        //2.33 Verify Total is “$2,950.00”
        verifyText("Invalid method", getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']")));

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.35 Verify the Text “Thank You”
        verifyText("Invalid greeting", getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']")));

        //2.36 Verify the message “Your order has been successfully processed!”
        verifyText("Invalid order success message",getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")));

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.37 Verify the text “Welcome to our store”
        verifyText("Invalid entry message on website", getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']")));
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
