package Type_Classes;

public enum Seasons {

    WINTER("Low","sd"), SPRING("Medium","sd"),
    SUMMER("High","sd"), FALL("Medium","sd");
    private final String expectedVisitors;
    private final String expectedVisitors2;


    private Seasons(String expectedVisitors, String expectedVisitors2) {
        this.expectedVisitors = expectedVisitors;
        this.expectedVisitors2 = expectedVisitors2;
    }

    public String printExpectedVisitors() {
        return expectedVisitors + expectedVisitors2;
    }
}
