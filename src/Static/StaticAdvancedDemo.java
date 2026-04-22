package Static;

/**
 * Ví dụ nâng cao về từ khóa 'static'.
 * - Static Initialization Block: khởi tạo dữ liệu phức tạp.
 * - Thứ tự khởi tạo giữa Static block và Instance block.
 * - Static Import: cách sử dụng hằng số tiện lợi.
 */
import static java.lang.Math.*; // Static import

public class StaticAdvancedDemo {
    private static int counter;
    private int id;

    // 1. Static initialization block: chạy khi class được nạp vào JVM
    static {
        System.out.println("--- Static Block: Đang khởi tạo counter ---");
        counter = 1000;
    }

    // 2. Instance initialization block: chạy mỗi khi có instance mới được tạo
    {
        System.out.println("--- Instance Block: Đang gán ID ---");
        id = ++counter;
    }

    public StaticAdvancedDemo() {
        System.out.println("--- Constructor: Hoàn tất khởi tạo instance " + id + " ---");
    }

    public static void main(String[] args) {
        System.out.println("Bắt đầu demo...");
        new StaticAdvancedDemo();
        new StaticAdvancedDemo();
        
        // Sử dụng phương thức từ static import
        System.out.println("Giá trị PI: " + PI);
        System.out.println("Căn bậc hai của 16: " + sqrt(16));
    }
}
