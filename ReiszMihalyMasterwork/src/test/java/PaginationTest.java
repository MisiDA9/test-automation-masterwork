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
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginationTest extends BaseTest {



  @Test
  @Feature("Pagination")
  @Description("After listing all products in the webshop and sorting for ascending price orders and navigating to the next page, every price should be less or equal to the next price on the second page as well")
  @DisplayName("TC_07 Listing products by price and navigating to the next page")
  public void listingData2() throws InterruptedException {
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

//    wait.until(ExpectedConditions.elementToBeClickable(allTheProducts.getNextButton()));
    Thread.sleep(2000);
    allTheProducts.getNextButton().click();


//     wait.until(ExpectedConditions.elementToBeClickable(allTheProducts.getPreviousButton()));
    Thread.sleep(4000);
    for (int i = 0; i < allTheProducts.getPrices().size()-1; i++) {
      Assertions.assertTrue(allTheProducts.getPrices().get(i) <= allTheProducts.getPrices().get(i + 1));
    }

  }

}
