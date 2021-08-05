package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  WebDriver driver;


  public BasePage(WebDriver driver) {
    this.driver = driver;

  }

}