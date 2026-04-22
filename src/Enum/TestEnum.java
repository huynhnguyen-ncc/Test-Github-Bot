package Enum;

// 1. Định nghĩa một interface
interface Describable {
    String getDescription();
}

// 2. Định nghĩa enum implement interface đó
enum DayOfWeek implements Describable {
    MONDAY("Ngày bắt đầu tuần"),
    TUESDAY("Ngày thứ hai"),
    WEDNESDAY("Ngày thứ ba"),
    THURSDAY("Ngày thứ tư"),
    FRIDAY("Ngày thứ năm"),
    SATURDAY("Cuối tuần — thứ bảy"),
    SUNDAY("Cuối tuần — chủ nhật");

    private final String description;

    // Constructor của enum luôn là private
    private DayOfWeek(String description) {
        this.description = description;
    }

    // Triển khai phương thức từ interface
    @Override
    public String getDescription() {
        return description;
    }
}

// 3. Sử dụng enum
public class TestEnum {
    public static void main(String[] args) {
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.printf("%s: %s%n", day, day.getDescription());
        }
    }
}

