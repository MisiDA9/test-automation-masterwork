package Pages;

import org.openqa.selenium.WebDriver;

public class TermsAndConditionsOfUse {
  WebDriver driver;

  public TermsAndConditionsOfUse(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public boolean isLoaded () {
    return getTitle().equals("Terms and conditions of use");
  }

  public void open () {
    driver.get("http://test-automation-shop1.greenfox.academy/content/3-terms-and-conditions-of-use");
  }


}
