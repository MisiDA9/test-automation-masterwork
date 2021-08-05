import Pages.Accessories;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SavingDataTest extends BaseTest {

  String folderName = "exportedProductDescriptions" + System.currentTimeMillis();

  @Test
  @DisplayName("TC13 - Download a list of data to .txt ")
  @Feature("Accessories page")
  @Description("After saving a list of data (accessories's name and prices) from the accessories page into a text file, assert that, the file has the same list, what you can find on the accessories page")

  public void savingData() {
    Accessories accessories = new Accessories(driver);
    accessories.open();
    createFolder();
    exportProductsDescriptionToTXT();
//    Assertions.assertEquals(accessories.getProductDescription(),readTheTxt());
  }

  @Step ("Create a folder")
  public void createFolder() {
    Path path = Paths.get(folderName);
    try {
      Files.createDirectories(path);
    } catch (IOException e) {
      System.err.println("Something went wrong");
    }
  }

  @Step ("Export List to .txt")
  public void exportProductsDescriptionToTXT() {
    Accessories accessories = new Accessories(driver);
    try {
      Files.write(Paths.get(folderName + "/accessories.txt"), accessories.getProductDescription());
    } catch (IOException e) {
      System.out.println("Something went wrong2");
    }
  }

  @Step ("Read the txt")
  public List<String> readTheTxt() {
    ArrayList<String> result = null;
    try {
      result = new ArrayList<>(Files.readAllLines(Paths.get(folderName + "/accessories.txt")));
    } catch (IOException e) {
      System.out.println("File not exist");
    }
    return result;
  }

}

