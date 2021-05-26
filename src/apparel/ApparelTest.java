package apparel;

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ApparelTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);  //this method comes from BaseTest
    }

    @Test
    public void verifyUserShouldNavigateToAccessoriesPageSuccessfully() throws InterruptedException {
        /** 1.1 Mouse Hover on “Apparel”Tab
         *  1.2 Mouse Hover on “Accessories” and click
         */
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        mouseHoverToElementAndClick(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[3]"));

        /** 1.3 Verify the text “Accessories”*/
        Thread.sleep(2000);
        String expectedtext1 = "Accessories";
        String actualtext1 = getTextFromElement(By.xpath("//h1[contains(text(),'Accessories')]"));
        Assert.assertEquals("Text does not match", expectedtext1, actualtext1);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        /** 2.1 Mouse Hover on “Apparel” Tab
         * 2.2 Mouse Hover on “Accessories” and click */

        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        mouseHoverToElementAndClick(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[3]"));

        /**  2.3 Verify the text “Accessories”*/
        Thread.sleep(2000);
        String expectedtext1 = "Accessories";
        String actualtext1 = getTextFromElement(By.xpath("//h1[contains(text(),'Accessories')]"));
        Assert.assertEquals("Text does not match", expectedtext1, actualtext1);

        /**  2.4 Click on List View Tab*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        /** 2.5 Click on product name “Ray Ban Aviator Sunglasses” link */
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]"));

        /** 2.6 Verify the text “Ray Ban Aviator Sunglasses”*/
        Thread.sleep(3000);
        String expectedtest1 =  "Ray Ban Aviator Sunglasses";
        String actualtest1 = getTextFromElement(By.xpath("//h1[contains(text(),'Ray Ban Aviator Sunglasses')]"));
        Assert.assertEquals("Text Nokia Lumia 1020 does not match.", expectedtest1, actualtest1);

        /** 2.7 Verify the price “$25.00”*/
        Thread.sleep(3000);
        String expectedprice1 =  "$25.00";
        String actualprice1  = getTextFromElement(By.xpath("//span[@id='price-value-33']"));
        Assert.assertEquals("Price do not match", expectedprice1,actualprice1);

        /** 2.8 Change quantity to 5*/
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_33']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_33']"),"5");

        /** 2.9 Click on “ADD TO CART” tab*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-33']"));

        /** 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
         After that close the bar clicking on the cross button.*/
        Thread.sleep(3000);
        String expectedmessage1 =  "The product has been added to your shopping cart";
        String actualmessage1 = getTextFromElement(By.xpath("//div[@id='bar-notification']"));
        Assert.assertEquals("Product added message is not displayed", expectedmessage1,actualmessage1);

        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        /** 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.*/
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//span[text()='Shopping cart']"));
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));

        /** 2.12 Verify the message "Shopping cart"*/
        Thread.sleep(3000);
        String expectedmessage2 = "Shopping cart";
        String actualmessage2 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping cart is not displayed", expectedmessage2,actualmessage2);

        /** 2.13 Verify the quantity is 5*/
        Thread.sleep(10000);
        String expectedquantity1 = "(5)";
        String actualquantity1 = getTextFromElement(By.xpath("//span[contains(text(),'(5)')]"));
        Assert.assertEquals("Quantity display is not correct", expectedquantity1,actualquantity1);

        /** 2.14 Verify the Total $125.00*/
        Thread.sleep(10000);
        String expectedTotal = "$125.00";
        String actualTotal = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("Total display is not correct", expectedTotal,actualTotal);

        /** 2.15 click on checkbox “I agree with the terms of service”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //driver.findElement(By.xpath("//input[@id='termsofservice']")).click();

        /** 2.16 Click on “CHECKOUT”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

        /** 2.17 Verify the Text “Welcome, Please Sign In!”*/
        Thread.sleep(3000);
        String expectedText = "Welcome, Please Sign In!";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Welcome message is not correctly displayed", expectedText,actualText);

        /** 2.18 Send Text in “Email field”*/
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='Email']"),"gop@gmail.com");

        /** 2.19 Send Text in “Password field”*/
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='Password']"),"S999ugar");

        /** 2.20 Click on "LOG IN" button*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        /** 2.21 Verify the text “Shopping cart”*/
        Thread.sleep(3000);
        String expectedText2 = "Shopping cart";
        String actualText2 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Text is not displayed", expectedText2, actualText2);

        /**  2.22 click on checkbox “I agree with the terms of service”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        /** 2.23 Click on “CHECKOUT”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

      /* *//**  2.24 Fill the Mandatory fields - Not including these fields as it is directly selecting address and ask to continue*//*
        Thread.sleep(3000);
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"225"); //spain
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Granada");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Plaza Arquitecto García ");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "18010");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "00349585009");*/

        /** 2.25 Click on “CONTINUE”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
                                 //body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]
        /** 2.26 Click on Radio Button “2nd Day Air ($0.00)”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));

        /** 2.27 Click on “CONTINUE”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        /** 2.28 Select Radio Button “Credit Card” and continue*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        /** 2.29 Select “Amex” From Select credit card dropdown */
        Thread.sleep(3000);
        selectByValueFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Amex");

        /** 2.30 Fill all the details*/
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Gopal N");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"373207132839408");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"7");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2022");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"813");

        /** 2.31 Click on “CONTINUE”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        /** 2.32 Verify “Payment Method” is “Credit Card”*/
        Thread.sleep(3000);
        String expectedMethod1 = "Payment Method: Credit Card";
        String actualMethod1 = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]"));
        Assert.assertEquals("Payment Method is not correct", expectedMethod1,actualMethod1);

        /** 2.33 Verify “Shipping Method” is “2nd Day Air”*/
        Thread.sleep(3000);
        String expectedMethod2 = "Shipping Method: 2nd Day Air";
        String actualMethod2 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]"));
        Assert.assertEquals("Shipping Method is not correct", expectedMethod2,actualMethod2);

        /** 2.34 Verify Total is “$125.00”*/
        Thread.sleep(3000);
        String expectedTotal1 = "$125.00";
        String actualTotal1 = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("Total is not correct", expectedTotal1,actualTotal1);

        /** 2.35 Click on “CONFIRM”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        /** 2.36 Verify the Text “Thank You”*/
        Thread.sleep(5000);
        String expectedText3 = "Thank you";
        String actualText3 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Text Thank you is not displayed", expectedText3,actualText3);

        /** 2.37 Verify the message “Your order has been successfully processed!”*/
        Thread.sleep(10000);
        String expectedmessage3 = "Your order has been successfully processed!";
        String actualmessage3 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Message order successfully processed is not displayed", expectedmessage3,actualmessage3);

        /** 2.38 Click on “CONTINUE”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        /** 2.39 Verify the text “Welcome to our store”*/
        Thread.sleep(3000);
        String expectedText4 = "Welcome to our store";
        String actualText4 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Text Welcome to our store is not displayed", expectedText4,actualText4);

        /** 2.43 Click on “Logout” link*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        /**  2.44 Verify the URL is “https://demo.nopcommerce.com/”*//*
        Thread.sleep(3000);
        String expectedText5 = "nopCommerce";
        String actualText5 = getTextFromElement(By.xpath("//body/div[6]/div[1]/div[2]/div[1]"));
        Assert.assertEquals("URL is not correct", expectedText5,actualText5);*/

    }

    @After
    public void tearDown(){
        closeBrowser();
    }


}