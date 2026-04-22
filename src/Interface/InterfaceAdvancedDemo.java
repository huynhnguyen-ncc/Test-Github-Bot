package Interface;

/**
 * Ví dụ nâng cao về Interface.
 * - Default Methods và cách giải quyết xung đột (Diamond Problem).
 * - Static Methods trong Interface.
 * - Private Methods trong Interface (Java 9+).
 * - Functional Interfaces và @FunctionalInterface.
 */
interface Logger {
    default void log(String msg) {
        System.out.println(formatMessage(msg));
    }

    static void info(String msg) {
        System.out.println("[INFO]: " + msg);
    }

    // Private method: dùng để tái sử dụng code bên trong interface
    private String formatMessage(String msg) {
        return "[LOG - " + System.currentTimeMillis() + "]: " + msg;
    }
}

interface Messenger {
    default void log(String msg) {
        System.out.println("Messenger: " + msg);
    }
}

public class InterfaceAdvancedDemo implements Logger, Messenger {

    // Giải quyết xung đột default method bằng cách ghi đè
    @Override
    public void log(String msg) {
        Logger.super.log(msg); // Chọn implementation của Logger
    }

    public static void main(String[] args) {
        InterfaceAdvancedDemo demo = new InterfaceAdvancedDemo();
        demo.log("Kiểm tra Default Method");

        Logger.info("Kiểm tra Static Method");
    }
}
