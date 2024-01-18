package pages.components;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalDialogComponent {

    public void checkWindow() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void checkEmptyWindow() {
        $(".modal-dialog").shouldNot(appear);
    }

    public ModalDialogComponent checkResult(String key, String value) {
        if (!Configuration.browser.equalsIgnoreCase("firefox") && "Picture".equals(key)) {
            $(".table-responsive").$(byText(key)).parent()
                    .shouldHave(text(value));
        }
        return this;
    }
}
