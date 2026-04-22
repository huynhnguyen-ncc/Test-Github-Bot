package Exception;

public class NullDemo {
    public static void printLength(String s) {
        // Không kiểm tra null => nếu s == null, sẽ tự nhiên ném NullPointerException
        System.out.println("Độ dài chuỗi: " + s.length());
    }

    public static void main(String[] args) {
        printLength("Hello");
        printLength(null);  // tại đây sẽ gặp NullPointerException
//        try {
//            printLength(null);
//        } catch (NullPointerException e) {
//            // Bắt và tự in stack trace
//            System.err.println("Có lỗi khi tính độ dài chuỗi:");
//            e.printStackTrace();
//        }
    }
}