package settings;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class DriverSetup {

    private WebDriver driver;
    private final String NODEURL = "http://127.0.0.1:4444/wd/hub";

    public DriverSetup(String browser_name, boolean headless, boolean remoteServer) throws MalformedURLException {

        if(browser_name.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();

            if (headless) {
                options.addArguments("--headless");
            }
            if (remoteServer) {
                driver = new RemoteWebDriver(new URL(NODEURL), options);
            } else {
                driver = new ChromeDriver(options);
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebDriver getDriver(){
        return driver;
    }

}
