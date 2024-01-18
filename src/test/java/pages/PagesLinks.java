package pages;

public enum PagesLinks {

    REGISTRATION_FORM("/automation-practice-form", "Practice Form"),
    LOGIN("/login", "Login"),
    TEXT_BOX("/text-box", "Text Box"),
    PROFILE("/profile", "Profile");

    private final String link;

    PagesLinks(String link, String header) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

}
