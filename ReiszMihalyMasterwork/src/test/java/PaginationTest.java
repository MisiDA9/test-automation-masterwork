import Pages.AllTheProducts;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PaginationTest extends BaseTest {
  @Test
  @Feature("Pagination")
  @Description("After listing all products in the webshop and sorting for ascending price orders and navigating to the next page, every price should be less or equal to the next price on the second page as well")
  @DisplayName("TC_07 Listing products by price and navigating to the next page")
  public void listingData2() {
    AllTheProducts allTheProducts = new AllTheProducts(driver);
    allTheProducts.open();
    listingTheProducts();
    navigateToTheNextPage();

    for (int i = 0; i < allTheProducts.getPrices().size()-1; i++) {
      Assertions.assertTrue(allTheProducts.getPrices().get(i) <= allTheProducts.getPrices().get(i + 1));
    }
  }

  @Step("Listing and sorting all the products by price in ascending order")
  public void listingTheProducts() {
    AllTheProducts allTheProducts = new AllTheProducts(driver);
    allTheProducts.getFilterSelect().click();
    allTheProducts.getFromLowToHigh().click();
  }

  @Step("Navigate to the next page")
  public void navigateToTheNextPage() {
    AllTheProducts allTheProducts = new AllTheProducts(driver);
    allTheProducts.getNextButton().click();
  }

}
