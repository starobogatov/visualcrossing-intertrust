package visualcrossing.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    private static final SelenideElement cookieModal = $(".cookieModal .modal-content");

    public void acceptCookies() {
        if (cookieModal.isDisplayed()) {
            cookieModal
                    .$(".btn-primary").as("button 'Accept all cookies'")
                    .click();
        }
    }

}
