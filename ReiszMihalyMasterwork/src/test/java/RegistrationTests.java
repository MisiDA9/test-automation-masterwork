import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegistrationTests extends BaseTest {
  @Test
  @DisplayName("TC01 - Successful  attempt")
  @Feature("Registration")
  @Description("After a successful registration attempt with valid inputs, assert that the expected name in the header is the same with the input name.")
  public void signUpToTheWebshopSuccessfulAttempt () {
    signUp();
    makeScreenshot();

    String expectedName = "Michael Test";
    HomePage homePage = new HomePage(driver);
    String actual = homePage.getActualName();
    Assertions.assertEquals(expectedName, actual);
    signingOut();
  }

  @Test
  @DisplayName("TC02 - Unsuccessful  attempt")
  @Feature("Registration")
  @Description("After an unsuccessful registration attempt with an already used email address, assert that the error message is correct.")
  public void signUpToTheWebshopUnsuccessfulAttempt() {
    signUpTwiceWithARandomNumberInEmailAddress();

    String expectedMessage = "The email is already used, please choose another one or sign in";
    Registration signUpPage = new Registration(driver);
    String actual = signUpPage.getEmailIsAlreadyExistMessage();
    Assertions.assertEquals(expectedMessage, actual);
  }

  @Step ("Signing up twice with the same email address (random email - reusable)")
  public void signUpTwiceWithARandomNumberInEmailAddress() {
    int sameRandomNumber = (int) System.currentTimeMillis();
    Registration signUpPage = new Registration(driver);
    signUpPage.open();
    signUpPage.signUp("Michael", "Test", sameRandomNumber + "michael@test.com", "pass123");
    signingOut();
    signUpPage.open();
    signUpPage.signUp("Michael", "Test", sameRandomNumber + "michael@test.com", "pass123");
  }
}





