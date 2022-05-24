package fr.phe.shadow.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Unshadow;
import org.fluentlenium.core.domain.FluentWebElement;

public class ShadowRootPage extends FluentPage {

    @Override
    public void verifyIsLoaded() {
        await().until(el("div#container")).displayed();
    }

    @Unshadow(css = {"#container", "#inside"})
    FluentWebElement inter;
    
    @Unshadow(css = {"#container", "textarea#txt"})
    FluentWebElement text;
	
    public String getShadowRootItemText() {
        return inter.text();
    }

    public String getShadowRootTextarea() {
        return text.value();
    }

    public void setShadowRootTextarea(String val) {
        text.clear();
        text.fill().with(val);
        
    }
}

