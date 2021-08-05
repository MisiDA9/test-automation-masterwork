package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
  WebDriver driver;

  public Login (WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getEmail () {
    return driver.findElement(By.name("email"));
  }

  public WebElement getPassword () {
    return driver.findElement(By.name("password"));
  }

  public WebElement getSignInButton () {
    return driver.findElement(By.id("submit-login"));
  }

  public void open () {
    driver.get("http://test-automation-shop1.greenfox.academy/login?back=my-account");
  }

  public void login (String email, String password) {
    getEmail().sendKeys(email);
    getPassword().sendKeys(password);
    getSignInButton().click();
  }

  public String loginToYourAccount () {
    return driver.findElement(By.xpath("//*[@id=\"main\"]/header/h1")).getText();
  }

}
