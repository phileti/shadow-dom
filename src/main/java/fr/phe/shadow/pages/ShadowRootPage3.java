package fr.phe.shadow.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Unshadow;
import org.fluentlenium.core.domain.FluentWebElement;

public class ShadowRootPage3 extends FluentPage {

    @Override
    public void verifyIsLoaded() {
        await().until(el("div#shadow_host")).displayed();
    }

    
	@Unshadow(css = {"#shadow_host", "#shadow_content"})
	private FluentWebElement content;
	
	public String getShadowContentText() {
		return content.text();
	}

	@Unshadow(css = { "#shadow_host", "input[type='text']" })
	private FluentWebElement texte;
	
	public String getShadowInputValue() {
		return texte.value();
	}
	
	public void setShadowInputValue(String text) {
		if (!getShadowInputValue().isEmpty()) {
			texte.clear();
		}
		texte.fill().with(text);
	}
}

