package Lambda;

import java.util.function.Consumer;

public class ConsumerMethodDemo {
    public static void main(String[] args) {
        // 1. Một Consumer cơ bản: in ra console với tiền tố ">> "
        Consumer<String> printer = s -> System.out.println(">> " + s);

        // 2. Một Consumer khác: in độ dài chuỗi
        Consumer<String> lengthLogger = s ->
                System.out.println("   (length = " + s.length() + ")");

        // 3. Ghép hai Consumer với andThen()
        Consumer<String> combined = printer.andThen(lengthLogger);

        // 4. Thử với một chuỗi
        String message = "Hello World";
        combined.accept(message);

        // 5. Bạn vẫn có thể dùng printer hoặc lengthLogger riêng lẻ
        printer.accept("Standalone");
        lengthLogger.accept("Standalone");
    }
}
