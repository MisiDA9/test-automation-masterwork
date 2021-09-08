import Pages.AllTheProducts;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ListingDataTest extends BaseTest {
  @Test
  @Feature("Listing data")
  @Description("After listing all products in the webshop and sorting for ascending price orders, every price should be less or equal to the next price.")
  @DisplayName("TC_06 Listing products by price - ascending")
  public void listingData() {
    AllTheProducts allTheProducts = new AllTheProducts(driver);
    allTheProducts.open();
    listingTheProducts();

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

}
