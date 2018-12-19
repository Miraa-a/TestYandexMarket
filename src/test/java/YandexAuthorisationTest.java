import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import interior.DriverCharge;

public class YandexAuthorisationTest {


    private static final int TIMEOUT_SEC = 10;
    private static final String PAGENAME = "https://market.yandex.ru/";
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeTest
    public void init(ITestContext testContext)
    {
        driver = DriverCharge.setDriver();
        wait = DriverCharge.setWait(driver, TIMEOUT_SEC);
        testContext.setAttribute("WebDriver", this.driver);
    }

    @Description("Test for login popup")
    @Test(groups = { "basic" })
    public void loginTest(){
        DriverCharge.loadPage(driver, PAGENAME);

        String login = YandexAuthorisation.login(wait, driver);
        Assert.assertEquals(YandexAuthorisation.getUserName(wait), login);
    }

    @AfterTest(alwaysRun=true)
    public void closeBrowser()
    {
        driver.close();
    }
}
