import Pages.AllTheProducts;
import Pages.HomePage;
import Pages.Login;
import Pages.MyAccount;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaginationTest extends BaseTest {


  @Test
  @Feature("Pagination")
  @Description("After listing all products in the webshop and sorting for ascending price orders and navigating to the next page, every price should be less or equal to the next price on the second page as well")
  @DisplayName("TC_07 Listing products by price and navigating to the next page")
  public void listingData2() throws InterruptedException {
    Login loginPage = new Login(driver);
    loginPage.open();

    loginPage.login("michael@test.com", "pass123");


    MyAccount myAccount = new MyAccount(driver);
    myAccount.getLogo().click();

    HomePage homePage = new HomePage(driver);
    homePage.allTheProdcuts().click();


    AllTheProducts allTheProducts = new AllTheProducts(driver);

    allTheProducts.getFilterSelect().click();
    allTheProducts.getFromLowToHigh().click();


    Thread.sleep(1000);
    allTheProducts.getNextButton().click();
    Thread.sleep(1000);
    driver.manage().window().fullscreen();

    for (int i = 0; i < allTheProducts.getPrices().size()-1; i++) {
      Assertions.assertTrue(allTheProducts.getPrices().get(i) <= allTheProducts.getPrices().get(i + 1));
    }

  }

}
