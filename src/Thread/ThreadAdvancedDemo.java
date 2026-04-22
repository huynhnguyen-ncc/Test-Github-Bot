package Thread;

import java.util.concurrent.*;

/**
 * Ví dụ nâng cao về Thread và Concurrency.
 * - Sử dụng ExecutorService thay vì tạo Thread thủ công.
 * - ThreadLocal: lưu trữ dữ liệu riêng biệt cho mỗi luồng.
 * - CompletableFuture: lập trình bất đồng bộ hiện đại.
 * - Atomic Variables: an toàn đa luồng không cần synchronized.
 */
public class ThreadAdvancedDemo {
    // ThreadLocal giúp mỗi luồng có bản sao biến riêng
    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) throws Exception {
        // 1. ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        executor.submit(() -> {
            threadId.set(101);
            System.out.println(Thread.currentThread().getName() + " có ID: " + threadId.get());
        });

        executor.submit(() -> {
            threadId.set(202);
            System.out.println(Thread.currentThread().getName() + " có ID: " + threadId.get());
        });

        executor.shutdown();

        // 2. CompletableFuture
        System.out.println("Bắt đầu tác vụ bất đồng bộ...");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            return "Kết quả từ tương lai";
        });

        future.thenAccept(result -> System.out.println("Nhận được: " + result));

        // Đợi một chút để thấy kết quả bất đồng bộ
        Thread.sleep(1500);
        System.out.println("Kết thúc chương trình.");
    }
}
