package selenium.enums;

public enum FormsTab {
    PRACTICE_FORM("Practice Form");

    private final String tabName;

    FormsTab(String tabName) {
        this.tabName = tabName;
    }

    public String getTabName() {
        return tabName;
    }
}
