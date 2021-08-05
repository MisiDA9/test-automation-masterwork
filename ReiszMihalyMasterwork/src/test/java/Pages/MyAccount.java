package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount {
  WebDriver driver;

  public MyAccount(WebDriver driver) {
    this.driver = driver;
  }
  public WebElement getSignOut() {
    return driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[1]"));
  }

  public void open () {
    driver.get("http://test-automation-shop1.greenfox.academy/my-account");
  }
}




