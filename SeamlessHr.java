import java.beans.Transient;
import java.security.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeamLessHr {
    @BeforeClass(alwaysRun = true)
    public static void main(String[] args) {
        System.setProperty("wedriver.chrome.driver", "C:\Users\DELL\Desktop\ene\chromedriver_win32\\ChromeDriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://theinternet.herokuapp.com");
        driver.manage().window().maximize(); 
    }

        @Test
         public void ValidLogin() throws Exception {
         driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[21]/a")).click();
         driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/div/input")).sendKeys("tomsmith");
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div/input")).sendKeys("SuperSecretPassword!");
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button/i")).click();
		 
         WebElement message = driver.findElement(By.xpath("/html/body/div[1]/div/div"));
        if(message.getAttribute("class").contains("You Logged into a secure area!")){
        System.out.println("Success message is " + message.getText());

         }
    }
    @Test2
    public void InvalidLogin() {
        driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[21]/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/div/input")).sendKeys("thomas");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div/input")).sendKeys("SecretPassword!");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button/i")).click();
        
        WebElement message = driver.findElement(By.xpath("/html/body/div[1]/div/div"));
       if(message.getAttribute("class").contains("Your username is invalid!")){
       System.out.println("error message is " + message.getText());

       }
    }
}