import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RegistrationTests extends BaseTest {
  @Test
  @DisplayName("TC01 - Successful  attempt")
  @Feature("Registration")
  @Description("After a successful registration attempt with valid inputs, assert that the expected name in the header is the same with the input name.")

  public void signUpToTheWebshopSuccessfulAttempt () {
    Registration signUpPage = new Registration(driver);
    signUpPage.open();
    signUpPage.signUp("Michael", "Test",    System.currentTimeMillis() + "michael@test.com", "pass123");
    makeScreenshot();
    String expectedName = "Michael Test";
    HomePage homePage = new HomePage(driver);
    String actual = homePage.getActualName();
    Assertions.assertEquals(expectedName, actual);
    signingOut();
  }

  @Test
  @DisplayName("TC05 - Privacy Policy button is clickable")
  @Feature("Registration")
  @Description("The link for the privacy policy page is correct and the privacy policy button is clickable.")
  public void shouldOpenPrivacyStatementAndCheckTheBox() {
    Registration signUpPage = new Registration(driver);
    signUpPage.open();

    String selectLinkOpenInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
    signUpPage.getTermsAndConditionsLink().sendKeys(selectLinkOpenInNewTab);
    signUpPage.getTermsAndConditions().click();
    assertTrue(signUpPage.getTermsAndConditions().isSelected());
    signingOut();
  }


  @Test
  @DisplayName("TC02 - Unsuccessful  attempt")
  @Feature("Registration")
  @Description("After an unsuccessful registration attempt with an already used email address, assert that the error message is correct.")
  public void signUpToTheWebshopUnsuccessfulAttempt() {
    int sameRandomNumber = (int) System.currentTimeMillis();

    Registration signUpPage = new Registration(driver);
    signUpPage.open();

    signUpPage.signUp("Michael", "Test", sameRandomNumber + "michael@test.com", "pass123");
    signingOut();

    signUpPage.open();
    signUpPage.signUp("Michael", "Test", sameRandomNumber + "michael@test.com", "pass123");

    String expectedMessage = "The email is already used, please choose another one or sign in";
    String actual = signUpPage.getEmailIsAlreadyExistMessage();
    Assertions.assertEquals(expectedMessage, actual);
  }




}





