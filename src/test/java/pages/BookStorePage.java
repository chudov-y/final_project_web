package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class BookStorePage {

    private final ElementsCollection booksCollection = $$(".action-buttons");

    private final SelenideElement searchInput = $("#searchBox"),
            header = $(".main-header"),
            noDataDiv = $(".rt-noData");


    public void search(String value) {
        searchInput.setValue(value);
    }

    public void checkFoundBook(String value) {
        booksCollection.shouldHave(exactTexts(value));
    }

    public void checkFoundBooks(List<String> values) {
        booksCollection.shouldHave(exactTexts(values));
    }

    public void checkNoDataMessage(String value) {
        noDataDiv.shouldHave(exactText(value));
    }

    public void openPage() {
        open("/books");
        header.shouldHave(text("Book Store"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
}