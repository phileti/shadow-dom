package fr.phe.shadow.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.assertj.core.api.Assertions.assertThat;
import java.text.MessageFormat;

import fr.phe.shadow.pages.ShadowRootPage;
import fr.phe.shadow.pages.ShadowRootPage2;
import fr.phe.shadow.pages.ShadowRootPage3;

class ShadowRootTest extends AbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ShadowRootTest.class);

	@Test
    void checkShadowRoot1() throws InterruptedException {
        goTo(AbstractTest.SHADOW_URL);
        this.getDriver().getPageSource();

        ShadowRootPage shadowRootPage = newInstance(ShadowRootPage.class);
        shadowRootPage.verifyIsLoaded();
        assertThat(shadowRootPage.getShadowRootItemText()).contains("Inside Shadow DOM");
        
        Thread.sleep(3000);
    }
    
    @Test
    void checkShadowRoot2() throws InterruptedException {
        goTo(AbstractTest.SHADOW_URL2);
        this.getDriver().getPageSource();

        ShadowRootPage2 shadowRootPage = newInstance(ShadowRootPage2.class);
        shadowRootPage.verifyIsLoaded();
        assertThat(shadowRootPage.getShadowRootItemText()).contains("Inside Shadow DOM");
        
		LOGGER.debug(MessageFormat.format("old value: [{0}]", shadowRootPage.getShadowRootTextarea()));
        String val="some new value";
        shadowRootPage.setShadowRootTextarea(val);
        assertThat(shadowRootPage.getShadowRootTextarea()).contains(val);
		LOGGER.debug(MessageFormat.format("new value: [{0}]", shadowRootPage.getShadowRootTextarea()));
        
        Thread.sleep(3000);
    }
    
    @Test
    void checkShadowRoot3() throws InterruptedException {
        goTo(AbstractTest.SHADOW_URL3);
        this.getDriver().getPageSource();

        ShadowRootPage3 shadowRootPage = newInstance(ShadowRootPage3.class);
        shadowRootPage.verifyIsLoaded();
        assertThat(shadowRootPage.getShadowContentText()).contains("some text");
        
		LOGGER.debug(MessageFormat.format("old value: [{0}]", shadowRootPage.getShadowInputValue()));
        String val="another new value";
        shadowRootPage.setShadowInputValue(val);
        assertThat(shadowRootPage.getShadowInputValue()).contains(val);
		LOGGER.debug(MessageFormat.format("new value: [{0}]", shadowRootPage.getShadowInputValue()));
        
        Thread.sleep(3000);
    }
}
