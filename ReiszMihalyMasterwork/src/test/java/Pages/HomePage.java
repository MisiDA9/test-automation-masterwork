package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

  WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  //username
  public String getActualName() {
    return driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span")).getText();
  }

  public WebElement allTheProdcuts () {
    return driver.findElement(By.xpath("//*[@id=\"content\"]/section/a"));
  }

}
