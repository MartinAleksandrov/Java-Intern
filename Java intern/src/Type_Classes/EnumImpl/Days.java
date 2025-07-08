package Type_Classes.EnumImpl;

public enum Days implements Describable {

    MONDAY(1,"Start of the work week"),
    TUESDAY(2,"Second work day"),
    WEDNESDAY(3,"Midweek"),
    THURSDAY(4,"Almost there"),
    FRIDAY(5,"End of the work week"),
    SATURDAY(6,"Weekend! Time to relax."),
    SUNDAY(7,"Rest and prepare for Monday");

    private final int value;
    private final String description;

    private Days(int value,String description) {
        this.description = description;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    //Търси конкретна еnum инстанця по стойност
    public static Days fromValue(int value) {
        for (Days day : Days.values()) {
            if (day.value == value) {
                return day;
            }
        }
        throw new IllegalArgumentException("Invalid day value: " + value);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String writeDescription() {
        return description;
    }
}
