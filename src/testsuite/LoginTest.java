package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.UtilityParaBank;

public class LoginTest extends UtilityParaBank {
    @Before
    public void setUp(){
        //open browser and launch URL
        openBrowser("https://parabank.parasoft.com/parabank/index.htm");
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //-----------------register--------------------------
        //click on register link
        clickOnElement(By.xpath("//a[text()='Register']"));
        //Enter first name
        sendTextToElement(By.id("customer.firstName"),"Ananya");
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
        sendTextToElement(By.id("customer.username"),"ananyapatel321");
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
        //open browser and launch URL
        openBrowser("https://parabank.parasoft.com/parabank/index.htm");
        //--------------------------login--------------------------
        //enter valid username
        sendTextToElement(By.xpath("//input[@name='username']"), "ananyapatel321");
        //enter valid password
        sendTextToElement(By.xpath("//input[@name='password']"), "Patelabc123");
        //click on login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //verify the 'Accounts Overview'
        //define expected text
        String expectedTextAccounts = "Accounts Overview";
        //define actual text
        String actualTextAccounts = getTextFromElement(By.xpath("//h1[@class='title']"));
        //verify if expected is equal to actual
        Assert.assertEquals("Not signed in", expectedTextAccounts, actualTextAccounts);
    }

    @Test
    public void verifyTheErrorMessage() {
        //enter invalid username
        sendTextToElement(By.xpath("//input[@name='username']"), "priyanka321");
        //enter invalid password
        sendTextToElement(By.xpath("//input[@name='password']"), "priyanka123");
        //click on login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //define expected
        String expectedErrorMessage = "The username and password could not be verified.";
        //get actual
        String actualErrorMessage = getTextFromElement(By.xpath(""));
        //Verify the error message ‘The username and password could not be verified.’
        Assert.assertEquals("",expectedErrorMessage,actualErrorMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //-----------------register--------------------------
        //click on register link
        clickOnElement(By.xpath("//a[text()='Register']"));
        //Enter first name
        sendTextToElement(By.id("customer.firstName"),"Dipali");
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
        sendTextToElement(By.id("customer.username"),"dipalipatel321");
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
        //open browser and launch URL
        openBrowser("https://parabank.parasoft.com/parabank/index.htm");
        //enter a valid username
        sendTextToElement(By.xpath("//input[@name='username']"), "dipalipatel321");
        //enter valid password
        sendTextToElement(By.xpath("//input[@name='password']"), "Patelabc123");
        //click on login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //click on logout button
        clickOnElement(By.xpath("//a[text()='Log Out']"));
        //define expected logout text
        String expectedLogoutText = "Customer Login";
        //get actual logout text
        String actualLogoutText = getTextFromElement(By.xpath("//div[@id='leftPanel']/h2"));
        //Verify if expected is equal to actual
        Assert.assertEquals("Not Logged Out", expectedLogoutText,actualLogoutText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
