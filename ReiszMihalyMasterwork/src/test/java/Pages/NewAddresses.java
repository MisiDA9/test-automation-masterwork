package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewAddresses {
  WebDriver driver;

  public NewAddresses(WebDriver driver) {
    this.driver = driver;
  }


  public void open () {
    driver.get("http://test-automation-shop1.greenfox.academy/address");
  }

  public WebElement getAddress () {
    return driver.findElement(By.name("address1"));
  }

  public WebElement getCity () {
    return driver.findElement(By.name("city"));
  }

  public WebElement getState () {
    return driver.findElement(By.name("id_state"));
  }

  public WebElement getPostcode () {
    return driver.findElement(By.name("postcode"));
  }

  public WebElement getSaveButton () {
    return driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
  }

  public void newAddressesInput (String address, String city, String state, String postcode) {
    getAddress().sendKeys(address);
    getCity().sendKeys(city);
    getState().sendKeys(state);
    getPostcode().sendKeys(postcode);
    getSaveButton().click();
  }


}
