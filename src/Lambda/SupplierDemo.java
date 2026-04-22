package Lambda;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        // Khởi tạo một Supplier<LocalDateTime> để lấy thời điểm hiện tại
        Supplier<LocalDateTime> nowSupplier = () -> LocalDateTime.now();

        // Supplier chưa thực thi gì cho đến khi get() được gọi
        System.out.println("Chưa gọi get(): chưa có giá trị nào được tạo.");

        // Lần đầu gọi get(), giá trị LocalDateTime được sinh ra tại thời điểm này
        LocalDateTime firstCall = nowSupplier.get();
        System.out.println("Lần 1 get(): " + firstCall);

        // Giữa hai lần gọi có độ trễ, để thấy sự khác biệt
        try {
            Thread.sleep(5000);  // tạm dừng 1.5 giây
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Lần thứ hai gọi get(), giá trị mới được sinh ra tại thời điểm này
        LocalDateTime secondCall = nowSupplier.get();
        System.out.println("Lần 2 get(): " + secondCall);
    }
}
