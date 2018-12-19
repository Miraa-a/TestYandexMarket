import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import interior.DriverCharge;

public class SwapSaratovAndEngelsTest {


    private static final int TIMEOUT_SEC = 10;
    private static final String SITE_URL = "https://market.yandex.ru/";
    private static final String TEMP_CITY = "Энгельс";
    private static final String CITY_CLASS_1 = ".n-region-notification__back-to";
    private static final String CITY_CLASS_2 = "span.link:nth-child(1) > span:nth-child(2)";
    private static final String LOCATION_CITY = "Саратов";
    private static WebDriver driver;
    private static WebDriverWait wait;



    @BeforeTest
    public void init(ITestContext testContext)
    {
        driver = DriverCharge.setDriver();
        wait = DriverCharge.setWait(driver, TIMEOUT_SEC);
        testContext.setAttribute("WebDriver", this.driver);
    }

    @Test(groups = { "basic" })
    @Description("Try to switch city to yandex popup")
    public void yandexMarketChangeCity(){


        DriverCharge.loadPage(driver, SITE_URL);
        SwapSaratovAndEngels.changeCity(wait);
        SwapSaratovAndEngels.setCity(wait, TEMP_CITY);

        String changedCity = SwapSaratovAndEngels.getChangedCityName(wait);
        SwapSaratovAndEngels.getInitialCityName(wait, CITY_CLASS_1);
        Assert.assertEquals(changedCity, TEMP_CITY);

        String realCity = SwapSaratovAndEngels.getRealCityName(wait, CITY_CLASS_2);
        Assert.assertEquals(realCity, LOCATION_CITY);
    }

    @AfterTest(alwaysRun=true)
    public void closeBrowser()
    {
        driver.close();
    }

}
