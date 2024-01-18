package pages;

public enum PagesLinks {

    REGISTRATION_FORM("/automation-practice-form", "Practice Form"),
    LOGIN("/login", "Login"),
   // BOOK_STORE("/books", "Book Store"),
    TEXT_BOX("/text-box", "Text Box"),
    PROFILE("/profile", "Profile");

    private final String link;
   //         header;

    PagesLinks(String link, String header) {
        this.link = link;
    //    this.header = header;
    }

    public String getLink() {
        return link;
    }

//    public String getHeader() {
//        return header;
//    }
}
