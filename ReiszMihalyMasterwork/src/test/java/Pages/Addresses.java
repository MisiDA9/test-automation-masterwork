package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Addresses {
  WebDriver driver;

  public Addresses(WebDriver driver) {
    this.driver = driver;
  }
  public void open () {
    driver.get("http://test-automation-shop1.greenfox.academy/addresses");
  }

  public void deleteFirst (){
    driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]/span")).click();
  }

  public void updateFirst (){
     driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[1]/span")).click();
  }

  public WebElement getFeedbackMessage () {
    return driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article"));
  }

  public WebElement getFeedbackMessageAboutSuccessfulAddressAdding() {
    return driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
  }
}
