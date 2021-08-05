package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Accessories {
  WebDriver driver;

  public Accessories(WebDriver driver) {
    this.driver = driver;
  }

  public void open () {
    driver.get("http://test-automation-shop1.greenfox.academy/6-accessories");
  }

  public List<String> getProductDescription() {

    List<WebElement> productsDescriptionWebelements = driver.findElements(By.className("product-description"));
    ArrayList<String> productsDescription = new ArrayList<String>();

    for (int i = 0; i < productsDescriptionWebelements.size(); i++) {
      productsDescription.add(i,productsDescriptionWebelements.get(i).getText());
    }

    return productsDescription;
  }



}
