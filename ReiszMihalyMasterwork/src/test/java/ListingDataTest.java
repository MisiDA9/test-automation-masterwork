import Pages.AllTheProducts;
import Pages.HomePage;
import Pages.Login;
import Pages.MyAccount;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ListingDataTest extends BaseTest {


  @Test
  @Feature("Listing data")
  @Description("After listing all products in the webshop and sorting for ascending price orders, every price should be less or equal to the next price.")
  @DisplayName("TC_06 Listing products by price - ascending")
  public void listingData() throws InterruptedException {
    
//    Login loginPage = new Login(driver);
//    loginPage.open();
//
//    loginPage.login("michael@test.com", "pass123");
//
//
//    MyAccount myAccount = new MyAccount(driver);
//    myAccount.getLogo().click();
//
//    HomePage homePage = new HomePage(driver);
//    homePage.allTheProdcuts().click();


    AllTheProducts allTheProducts = new AllTheProducts(driver);
    allTheProducts.open();

    allTheProducts.getFilterSelect().click();
    allTheProducts.getFromLowToHigh().click();


//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    wait.until(ExpectedConditions.visibilityOf(allTheProducts.productList()));
    Thread.sleep(1000);
    for (int i = 0; i < allTheProducts.getPrices().size()-1; i++) {
      Assertions.assertTrue(allTheProducts.getPrices().get(i) <= allTheProducts.getPrices().get(i + 1));
    }
  }
}










//    Select select = new Select(allTheProducts.select());
//    select.selectByIndex(4);

//
//    @Test
//    public void pagination() throws InterruptedException {
//      Login loginPage = new Login(driver);
//      loginPage.open();
//
//      loginPage.login("aa@aa.hu", "aaaaa");
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//
//      MyAccount myAccount = new MyAccount(driver);
//      myAccount.logo().click();
//
//      HomePage homePage = new HomePage(driver);
//      homePage.allTheProdcuts().click();
//      driver.manage().window().maximize();
//      Thread.sleep(3000);
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//      AllTheProducts allTheProducts = new AllTheProducts(driver);
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//      allTheProducts.filterSelect();
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//      allTheProducts.getSelect().click();
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//      Thread.sleep(3000);
//
//

//    List<WebElement> pagination = driver.findElements(By.xpath("//div[@class='pagination-container']//a"));
//    int s = pagination.size();
//    for(int i=0;i<=s;i++){
//      this.getAuthors();
//      driver.get(Constants.url);
//      Thread.sleep(5000);
//
//      pagination = driver.findElements(By.xpath("//div[@class='pagination-container']//a"));
//      pagination.get(i).click();

//    }



    //miert csak igy mukodik??? kijelentkezessel



