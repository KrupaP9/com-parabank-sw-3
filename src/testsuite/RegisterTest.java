package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.UtilityParaBank;

public class RegisterTest extends UtilityParaBank {
    @Before
    public void setUp(){
        //open browser and launch URL
        openBrowser("https://parabank.parasoft.com/parabank/index.htm");
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //click on register link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //Define the expected text
        String expectedText = "Signing up is easy!";
        //get the actual text
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        //Check whether expected equals actual
        Assert.assertEquals("Not equal",expectedText,actualText);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //click on register link
        clickOnElement(By.xpath("//a[text()='Register']"));
        //Enter first name
        sendTextToElement(By.id("customer.firstName"),"Anjali");
        //enter last name
        sendTextToElement(By.id("customer.lastName"),"Patel");
        //Enter address
        sendTextToElement(By.id("customer.address.street"),"20 xyz road");
        //enter city
        sendTextToElement(By.id("customer.address.city"),"Coventry");
        //Enter state
        sendTextToElement(By.id("customer.address.state"),"West Midlands");
        //enter zip code
        sendTextToElement(By.id("customer.address.zipCode"),"CV11AD");
        //enter phone
        sendTextToElement(By.id("customer.phoneNumber"),"6784573835");
        //enter ssn
        sendTextToElement(By.id("customer.ssn"),"476542");
        //enter username
        sendTextToElement(By.id("customer.username"),"anjalipatel321");
        //enter password
        sendTextToElement(By.id("customer.password"),"Patelabc123");
        //enter confirm password
        sendTextToElement(By.id("repeatedPassword"),"Patelabc123");
        //click on register button
        clickOnElement(By.xpath("//input[@value='Register']"));
        //define expected text
        String expectedText = "Your account was created successfully. You are now logged in.";
        //get actual text
        String getActualText = getTextFromElement(By.xpath("//div[@id='bodyPanel']/div[2]/p"));
        //verify expected equals actual
        Assert.assertEquals("Not signed in", expectedText,getActualText);
    }
    public void tearDown(){
        closeBrowser();
    }
}
