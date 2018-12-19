import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import interior.KeyProcedure;
import java.util.Iterator;
import java.util.Set;

public class YandexAuthorisation {

    private static final String LOGIN = "#login";
    private static final String PASSWORD = "#passwd";
    private static final String BTN_SIGN = ".nb-button._nb-action-button.js-submit-button.domik-submit-button.nb-group-start";
    private static final String XPATH_USER_BUTTON = "html/body/div[1]/div/div[1]/noindex/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/a/span[1]";
    private static final String ACTUAL_USER_NAME = ".n-passport-suggest-popup-opener > a:nth-child(1) > span:nth-child(2)";
    private static final String LOGIN_NAME = "ismail0vaelmira";
    private static final String PASS = "wolf1268";

    public static String login(WebDriverWait wait, WebDriver driver){

        WebElement buttonLogin = driver.findElement(By.className("n-passport-suggest-popup-opener")).findElement(By.tagName("a"));
        buttonLogin.click();

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> handlesIterator = handles.iterator();

        while (handlesIterator.hasNext()){
            String parent = handlesIterator.next();
            String newWin = handlesIterator.next();
            driver.switchTo().window(newWin);

            KeyProcedure.sendKeysBySelect(wait, LOGIN, LOGIN_NAME);
            KeyProcedure.sendKeysBySelect(wait, PASSWORD, PASS);
            KeyProcedure.clickElemBySelect(wait, BTN_SIGN);

            driver.switchTo().window(parent);
        }
        KeyProcedure.clickElemByXPath(wait, XPATH_USER_BUTTON);
        return LOGIN_NAME;
    }

    public static String getUserName(WebDriverWait wait){
        return KeyProcedure.getTextOfField(wait, ACTUAL_USER_NAME);
    }

}
