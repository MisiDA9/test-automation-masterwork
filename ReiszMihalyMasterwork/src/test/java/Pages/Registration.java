package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {
  WebDriver driver;

  public Registration(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getFirstName () {
    return driver.findElement(By.name("firstname"));
  }

  public WebElement getLastName () {
    return driver.findElement(By.name("lastname"));
  }

  public WebElement getEmail () {
    return driver.findElement(By.name("email"));
  }

  public WebElement getPassword () {
    return driver.findElement(By.name("password"));
  }

  public WebElement getCustomerDataPrivacy () {
    return driver.findElement(By.name("customer_privacy"));
  }

  public WebElement getTermsAndConditions () {
    return driver.findElement(By.name("psgdpr"));
  }

  public WebElement getSaveButton () {
    return driver.findElement(By.xpath("//*[@id=\"customer-form\"]/footer/button"));
  }

  public WebElement getTermsAndConditionsLink() {
    return driver.findElement(By.xpath("//*[@id=\"customer-form\"]/section/div[10]/div[1]/span/label/a"));
  }

  public String getEmailIsAlreadyExistMessage() {
    return driver.findElement(By.xpath("//*[@id=\"customer-form\"]/section/div[4]/div[1]/div/ul/li")).getText();
  }

  public void open () {
    driver.get("http://test-automation-shop1.greenfox.academy/login?create_account=1");
  }

  public void signUp (String firstName, String lastName, String email, String password) {
    getFirstName().sendKeys(firstName);
    getLastName().sendKeys(lastName);
    getEmail().sendKeys(email);
    getPassword().sendKeys(password);
    getCustomerDataPrivacy().click();
    getTermsAndConditions().click();
    getSaveButton().click();
  }
}
