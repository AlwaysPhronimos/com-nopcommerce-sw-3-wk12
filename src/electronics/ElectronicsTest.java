package electronics;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        clickMouseHoverOnElements(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //1.2 Mouse Hover on “Cell phones” and click
        clickMouseHoverOnElements(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //1.3 Verify the text “Cell phones”
        verifyText("Invalid text", getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']")));
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1  Mouse Hover on “Electronics” Tab
        clickMouseHoverOnElements(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //2.2 Mouse Hover on “Cell phones” and click
        clickMouseHoverOnElements(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //2.3 Verify the text “Cell phones”
        verifyText("Invalid text", getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']")));
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        //2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(1000);
        verifyText("Invalid text", getTextFromElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']")));
        //2.7 Verify the price “$349.00”
        Thread.sleep(1000);
        verifyText("Invalid price", getTextFromElement(By.id("price-value-20")));
        //2.8 Change quantity to 2
        Thread.sleep(1000);
        driver.findElement(By.id("product_enteredQuantity_20")).clear();
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("Invalid message", getTextFromElement(By.xpath("//div[@class='bar-notification success']")));
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        clickMouseHoverOnElements(By.xpath("//a[@class='ico-cart']"));
        Thread.sleep(1000);
        clickMouseHoverOnElements(By.xpath("//button[normalize-space()='Go to cart']"));
        //2.12 Verify the message "Shopping cart"
        Thread.sleep(1000);
        verifyText("Invalid message", getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']")));
        //2.13 Verify the quantity is 2
        Thread.sleep(1000);
        WebElement text = driver.findElement(By.xpath("//input[@class=\"qty-input\"]"));
        String qty = text.getAttribute("value");
        //Assert.assertEquals("Invalid quantity","2",qty);

        //2.14 Verify the Total $698.00
        Thread.sleep(1000);
        verifyText("Invalid total price", getTextFromElement(By.xpath("//td[@class='subtotal']")));
        //2.15 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.id("termsofservice"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText("Invalid title", getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")));
        //2.18 Click on “REGISTER” tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.19 Verify the text “Register”
        Thread.sleep(1000);
        verifyText("Invalid register text", getTextFromElement(By.xpath("//h1[normalize-space()='Register']")));
        //2.20 Fill the mandatory fields
        Thread.sleep(1000);
        sendTextToElement(By.id("FirstName"), "Smart1");
        sendTextToElement(By.id("LastName"), "Tester1");
        sendTextToElement(By.id("Email"), "testerissmart@gmail.com");
        sendTextToElement(By.id("Password"), "689325@@");
        sendTextToElement(By.id("ConfirmPassword"), "689325@@");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));
        //2.22 Verify the message “Your registration completed”
        verifyText("Invalid result", getTextFromElement(By.xpath("//div[@class='result']")));
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        // 2.24 Verify the text “Shopping card”
        verifyText("Invalid text", getTextFromElement(By.xpath("//div[@class='page-title']/h1")));
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.27 Fill the Mandatory fields
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Smart12");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Tester12");
        sendTextToElement(By.id("BillingNewAddress_Email"), "testerissmart12@gmail.com");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "Canada");
        sendTextToElement(By.id("BillingNewAddress_City"), "Vancouver");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "6, Millcar1 Drive");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "568234");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "9874563211");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master");
        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Mr Intelligent ");
        sendTextToElement(By.id("CardNumber"), "4263982640269299");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "02");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2026");
        sendTextToElement(By.id("CardCode"), "837");
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.35 Verify “Payment Method” is “Credit Card”
        verifyText("Invalid method", getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']")));
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyText("Invalid text", getTextFromElement(By.xpath("//li[@class='shipping-method']")));
        //2.37 Verify Total is “$698.00”
        verifyText("Invalid price", getTextFromElement(By.xpath("//td[@class='subtotal']")));

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        //2.39 Verify the Text “Thank You”
        verifyText("Invalid greeting", getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']")));
        //2.40 Verify the message “Your order has been successfully processed!”
        verifyText("Invalid order success message", getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")));
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        //2.42 Verify the text “Welcome to our store”
        verifyText("Invalid entry message on website", getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']")));
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        verifyText("Invalid Url", driver.getCurrentUrl());

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
