import Pages.Registration;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrivacyStatementTest extends BaseTest{
  @Test
  @DisplayName("TC05 - Privacy Policy button is clickable")
  @Feature("Registration")
  @Description("The link for the privacy policy page is correct and the privacy policy button is clickable.")
  public void shouldOpenPrivacyStatementAndCheckTheBox() {
    Registration signUpPage = new Registration(driver);
    signUpPage.open();

    openPrivacyPolicy();
    tickingOffPrivacyPolicy();

    assertTrue(signUpPage.getTermsAndConditions().isSelected());
  }

  @Step("Open Privacy Policy")
  public void openPrivacyPolicy() {
    Registration signUpPage = new Registration(driver);
    String selectLinkOpenInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
    signUpPage.getTermsAndConditionsLink().sendKeys(selectLinkOpenInNewTab);
  }

  @Step("Ticking off the privacy policy box")
  public void tickingOffPrivacyPolicy() {
    Registration signUpPage = new Registration(driver);
    signUpPage.getTermsAndConditions().click();
  }
}
