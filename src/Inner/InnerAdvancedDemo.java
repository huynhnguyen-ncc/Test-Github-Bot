package Inner;

/**
 * Ví dụ nâng cao về Inner Classes.
 * - Static Nested Class vs Inner Class.
 * - Local Class bên trong phương thức.
 * - Anonymous Inner Class và sự liên quan đến Lambda.
 */
public class InnerAdvancedDemo {
    private String secret = "Dữ liệu nhạy cảm";

    // 1. Static Nested Class: không phụ thuộc vào instance của lớp bao ngoài
    public static class StaticConfig {
        public void info() {
            System.out.println("Đây là cấu hình Static");
        }
    }

    // 2. Member Inner Class: có quyền truy cập trực tiếp private fields của lớp cha
    public class Processor {
        public void process() {
            System.out.println("Đang xử lý: " + secret);
        }
    }

    public void start() {
        // 3. Local Class
        class LocalLogger {
            void log(String msg) {
                System.out.println("[LOG]: " + msg);
            }
        }
        LocalLogger logger = new LocalLogger();
        logger.log("Bắt đầu Processor...");
        
        Processor p = new Processor();
        p.process();
    }

    public static void main(String[] args) {
        // Khởi tạo Static Nested Class
        InnerAdvancedDemo.StaticConfig config = new InnerAdvancedDemo.StaticConfig();
        config.info();

        // Khởi tạo Member Inner Class
        InnerAdvancedDemo outer = new InnerAdvancedDemo();
        InnerAdvancedDemo.Processor inner = outer.new Processor();
        inner.process();
        
        outer.start();
    }
}
