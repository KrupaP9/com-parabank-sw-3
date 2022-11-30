package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UtilityParaBank extends BaseTest {
    public void clickOnElement(By by){
        //find element to click
        WebElement link = driver.findElement(by);
        //click on element
        link.click();
    }
    public void sendTextToElement(By by, String text){
        //find the element to enter text into
        WebElement field = driver.findElement(by);
        //send text
        field.sendKeys(text);
    }
    public String getTextFromElement(By by){
        //find the element to get text from
        WebElement element = driver.findElement(by);
        //return the text from the element as String
        return element.getText();
    }
    public void selectByVisibleTextFromDropDown(By by, String text){
        //method to select a dropdown based on visible text
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void selectByValue(By by, String text){
        //method to select a dropdown option by the value
        WebElement value = driver.findElement(by);
        Select select = new Select(value);
        select.selectByValue(text);
    }
    public void selectByIndex(By by, int num){
        //method to select a dropdown option by the order in which it appears
        WebElement index = driver.findElement(by);
        Select select = new Select(index);
        select.selectByIndex(num);
    }
    //method to switch to a popup
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    //method to accept a popup
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    //method to dismiss a popup
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    //method to send text to an alert
    public void sendTextToAlert(By by, String text){

        driver.switchTo().alert().sendKeys(text);
    }
    //method to get text from an alert
    public String getTextFromAlert(By by){

        return driver.switchTo().alert().getText();
    }
    //method to hover over an element
    public void mouseHoverToElement(By by){
        //create an object
        Actions actions = new Actions(driver);
        //define location 1
        WebElement text = driver.findElement(by);
        //define location 2
        WebElement text1 = driver.findElement(by);
        //move from location 1 to location 2
        actions.moveToElement(text).moveToElement(text1).build().perform();
        //actions.moveToElement(text).moveToElement(text1).click().build().perform();
    }
    //method to hover over and click an element
    public void mouseHoverAndClickOnElement(By by){
        //create an object
        Actions actions = new Actions(driver);
        //define location 1
        WebElement text = driver.findElement(by);
        //define location 1
        WebElement text1 = driver.findElement(by);
        //move from location 1 to location 2 and click
        actions.moveToElement(text).moveToElement(text1).click().build().perform();
    }
}
