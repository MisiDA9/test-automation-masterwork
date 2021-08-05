package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
  WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public String getActualName() {
    return driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span")).getText();
  }
}
