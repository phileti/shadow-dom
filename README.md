# Shadow DOM elements in Flunetlenium example

Recovery of web elements in a shadow DOM in URL files using Fluentlenium @Unshadow.

## checkShadowRoot1 test
Copy of the Fluentlenium project original [test](https://github.com/FluentLenium/FluentLenium/tree/develop/fluentlenium-integration-tests/src/test/java/org/fluentlenium/test/shadowroot).  
It tests access to a WebElement in a Shadow DOM using an html file containing the Shadow DOM to check (shadow.html).

## checkShadowRoot2 test
Modification of the original html file to add an input field (shadow2.html).  
It tests insertion of text in shadow input field.

## checkShadowRoot3 test
Created an html file (shadow3.html) containing the website's code in [shadow-fluentlenium-JU5 test project](https://github.com/phileti/shadow-fluentlenium-JU5).  
It tests insertion of text in shadow input field.