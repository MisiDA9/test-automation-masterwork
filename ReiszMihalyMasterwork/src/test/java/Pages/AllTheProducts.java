package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

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

  public WebElement productList() {
    return driver.findElement(By.id("js-product-list"));
  }


  public List<Integer> getPrices() {
//    List<WebElement> prices = driver.findElements(By.xpath("//span[@class='price']"));
    List<WebElement> prices = driver.findElements(By.className("price"));
    ArrayList<Integer> myList = new ArrayList<Integer>();

    for (int i = 0; i < prices.size(); i++) {
      if (prices.get(i).getText().length() == 5) {
        myList.add(i, (parseInt(prices.get(i).getText().substring(1, 2))));
      } else if (prices.get(i).getText().length() == 6) {
        myList.add(i, (parseInt(prices.get(i).getText().substring(1, 3))));
      } else if (prices.get(i).getText().length() == 7)
        myList.add(i, (parseInt(prices.get(i).getText().substring(1, 4))));
    }

    return myList;
  }

  public WebElement getPreviousButton() {
    return driver.findElement(By.className("previous js-search-link"));
  }

}
