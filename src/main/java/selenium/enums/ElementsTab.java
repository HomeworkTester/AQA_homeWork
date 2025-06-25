package selenium.enums;

public enum ElementsTab {
    TEXT_BOX("Text Box"),
    CHECK_BOX("Check Box"),
    RADIO_BUTTON("Radio Button"),
    WEB_TABLES("Web Tables"),
    BUTTONS("Buttons");

    private final String tabName;

    ElementsTab(String tabName) {
        this.tabName = tabName;
    }

    public String getTabName() {
        return tabName;
    }
}
