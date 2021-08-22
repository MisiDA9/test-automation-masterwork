package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class AllTheProducts {
  WebDriver driver;

  public AllTheProducts(WebDriver driver) {
    this.driver = driver;
  }

  public void open() {
    driver.get("http://test-automation-shop1.greenfox.academy/2-home");
  }

  public WebElement getFilterSelect() {
    return driver.findElement(By.xpath("//*[@id=\"js-product-list-top\"]/div[2]/div/div[1]/button/i"));
  }

  public WebElement getFromLowToHigh() {
    return driver.findElement(By.xpath("//*[@id=\"js-product-list-top\"]/div[2]/div/div[1]/div/a[5]"));
  }

  public WebElement getNextButton() {
    return driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/nav/div[2]/ul/li[3]/a/i"));
  }

  public List<Float> getPrices() {
    List<WebElement> prices = driver.findElements(By.className("price"));
    List<String> myList = new ArrayList<>();
    for (int i = 0; i < prices.size(); i++) {
      String priceString = prices.get(i).getText().substring(1);
      myList.add(priceString);
    }
    List<Float> pricesFloat = new ArrayList<>();
    for (String stringPrice : myList) {
      pricesFloat.add(Float.parseFloat(stringPrice));
    }
    return pricesFloat;
  }
}
