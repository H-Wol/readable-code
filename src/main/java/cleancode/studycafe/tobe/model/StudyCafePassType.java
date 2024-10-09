package cleancode.studycafe.tobe.model;

public enum StudyCafePassType {
    HOURLY("시간 이용권(자유석)"),
    WEEKLY("주단위 이용권(자유석)"),
    FIXED("1인 고정석");

    private final String displayName;

    StudyCafePassType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}