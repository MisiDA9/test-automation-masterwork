import Pages.Addresses;
import Pages.NewAddresses;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class DataEntryTestRepetitive_CSV extends BaseTest {
  @BeforeAll
  public void initEach() {
    signUp();
  }

//  Szándékosan benne hagyott kikommentelt kódrészlet, az előadáshoz kell, a 2 különböző irányelv bemutatására
//  @ParameterizedTest(name = "{4} Data entry: New address has been added with parameterized Test.")
  @ParameterizedTest(name = "Data entry: New address has been added with parameterized Test.")
  @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
  @Feature("Addresses")
  @Description("After adding an address, the success message should be correct every time.")
  public void paramTest1(String address, String city, String state, String postcode, String testCaseSerialNumber) {
    saveMultiplyNewAddresses();
    Addresses addresses = new Addresses(driver);
    Assertions.assertTrue(addresses.getFeedbackMessageAboutSuccessfulAddressAdding().getText().equals("Address successfully added!"));
  }

  @Step("Saving multiply new valid addresses from SCV")
  public void saveMultiplyNewAddresses() {
    NewAddresses newAddresses = new NewAddresses(driver);
    newAddresses.open();
    newAddresses.newAddressesInput("23 Bunting Road", "Naples", "Florida", "11111");
  }
}
