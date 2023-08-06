package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestClass extends SpotDraft{

         @Test(priority = 1)
         public void testCase1() throws Throwable 
         {
        	 //Search for any book in search bar
        	 String bookName = "Half Girlfriend";
             driver.findElement(By.xpath("//input[@placeholder='Search books']")).sendKeys(bookName);

             //Selecting the book from the search list
             Thread.sleep(2000);
             List<WebElement> listOfBooks = driver.findElements(By.xpath("//div[contains(@class,'gr-bookSearchResults')]/div/div/a/div/div"));
             for (WebElement i : listOfBooks) {
                 String bName = i.getText();
                 if (bName.contains(bookName)){
                     i.click();
                     break;
                 }
             }

             //Marking the book as 'Read'
             try{
                 driver.findElement(By.xpath("//span[text()='Want to read']/../../following-sibling::div/button/span")).click();
                 driver.findElement(By.xpath("(//div[@class='WTRStepShelving']//div//button)[3]")).click();
                 driver.findElement(By.xpath("//span[text()='Done']")).click();
             }
             catch(Exception e){
                 driver.findElement(By.xpath("//span[text()='Read']")).click();
                 Thread.sleep(2000);
                 driver.findElement(By.xpath("(//div[@class='WTRStepShelving']//div//button)[3]")).click();
                 driver.findElement(By.xpath("//span[text()='Done']")).click();
             }


             //Remove the book from shelf
             Thread.sleep(2000);
             driver.findElement(By.xpath("//span[text()='Read']")).click();
             Thread.sleep(2000);
             driver.findElement(By.xpath("(//div[@class='WTRStepShelving']//div//button)[4]")).click();
             Thread.sleep(2000);
             driver.findElement(By.xpath("//span[text()='Remove']")).click();
         }

}
