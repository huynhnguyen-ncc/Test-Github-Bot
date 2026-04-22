package Exception;

import java.util.logging.*;

/**
 * Ví dụ nâng cao về Exception Handling.
 * - Exception Chaining: liên kết các ngoại lệ.
 * - Try-with-resources: tự động đóng tài nguyên.
 * - Suppressed Exceptions: xử lý ngoại lệ bị ẩn.
 * - Sử dụng Logger thay cho printStackTrace.
 */
public class ExceptionAdvancedDemo {
    private static final Logger logger = Logger.getLogger(ExceptionAdvancedDemo.class.getName());

    public static void main(String[] args) {
        try {
            doSomething();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Lỗi xảy ra trong main", e);
            
            // Lấy ra các suppressed exceptions
            for (Throwable t : e.getSuppressed()) {
                logger.info("Suppressed: " + t.getMessage());
            }
        }
    }

    public static void doSomething() throws Exception {
        Exception mainException = null;
        try (AutoCloseableResource res = new AutoCloseableResource()) {
            res.use();
        } catch (Exception e) {
            mainException = new Exception("Lỗi chính khi xử lý nghiệp vụ", e);
            throw mainException;
        }
    }
}

class AutoCloseableResource implements AutoCloseable {
    public void use() throws Exception {
        throw new Exception("Lỗi khi sử dụng tài nguyên");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Đang đóng tài nguyên...");
        throw new Exception("Lỗi khi đóng tài nguyên");
    }
}
