import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import interior.KeyProcedure;

public class SwapSaratovAndEngels {

    private static final String CITY_BTN_CLASS_2 = ".button2_theme_normal";
    private static final String CITY_BTN_CLASS_1 = "span.link:nth-child(1)";
    private static final String CITY_INPUT = "div.input > span:nth-child(1) > input:nth-child(2)";
    private static final String BTN_AGREE = ".suggestick-list";
    private static final String BTN_CHANGE = ".button";
    private static final String CHANGED_CITY = "span.link:nth-child(1) > span:nth-child(2)";


    public static void changeCity(WebDriverWait wait) {

        WebElement anotherCity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CITY_BTN_CLASS_2)));

        WebElement City = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CITY_BTN_CLASS_1)));
        if (anotherCity != null)
            anotherCity.click();
        else
            City.click();
    }


    public static void setCity(WebDriverWait wait, String tempCity) {
        KeyProcedure.sendKeysBySelect(wait, CITY_INPUT, tempCity);

        KeyProcedure.clickElemBySelect(wait, BTN_AGREE);
        KeyProcedure.clickElemBySelect(wait, BTN_CHANGE);

    }

    public static String getChangedCityName(WebDriverWait wait) {
        return KeyProcedure.getTextOfField(wait, CHANGED_CITY);
    }

    public static void getInitialCityName(WebDriverWait wait, String initial_City) {
        KeyProcedure.clickElemBySelect(wait, initial_City);
    }

    public static String getRealCityName(WebDriverWait wait, String real_City) {
        return KeyProcedure.getTextOfField(wait, real_City);
    }
}




