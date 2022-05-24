package fr.phe.shadow.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.fluentlenium.configuration.FluentConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.fluentlenium.utils.UrlUtils.getAbsoluteUrlFromFile;

/**
 * Base class for integration tests.
 * <p>
 * Uses {@code htmlunit} as the underlying driver and provides local HTML files that you can use as test pages.
 */
@FluentConfiguration(webDriver = "chrome", capabilities = "{\"chromeOptions\": {\"args\": [\"window-size=1024,768\"]}}")
public abstract class AbstractTest extends FluentTest {

    public static final String SHADOW_URL = getAbsoluteUrlFromFile("shadow.html");
    public static final String SHADOW_URL2 = getAbsoluteUrlFromFile("shadow2.html");
    public static final String SHADOW_URL3 = getAbsoluteUrlFromFile("shadow3.html");
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    @BeforeAll
    public static void setUpChrome() {
		LOGGER.debug("@BeforeAll");
        WebDriverManager.chromedriver().setup();
    }
    
    @AfterAll
    public static void quitChrome() {
		LOGGER.debug("@AfterAll");
        WebDriverManager.chromedriver().quit();
    }

}
