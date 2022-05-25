package fr.phe.shadow.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Unshadow;
import org.fluentlenium.core.domain.FluentWebElement;

public class ShadowRootPage2 extends FluentPage {
    @Override
    public void verifyIsLoaded() {
        await().until(el("div#container")).displayed();
    }


    @Unshadow(css = {"#container", "#inside"})
    FluentWebElement inside;

    public String getShadowRootItemText() {
        return inside.text();
    }


    @Unshadow(css = {"#container", "#txt"})
    FluentWebElement text;

    public String getShadowRootTextarea() {
        return text.value();
    }

    public void setShadowRootTextarea(String val) {
        text.write(val);
    }
}

