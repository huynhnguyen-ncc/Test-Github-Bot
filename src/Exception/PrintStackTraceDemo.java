package Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintStackTraceDemo {

    public static int getNumberFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            return Integer.parseInt(sc.nextLine());
        } catch (FileNotFoundException e) {
            // In stack trace để xem exception đến từ đâu
            e.printStackTrace();
            // Có thể xử lý tiếp hoặc trả giá trị mặc định
            return -1;
        }
    }

    public static void main(String[] args) {
        // Giả sử file "missing.txt" không tồn tại
        int value = getNumberFromFile("missing.txt");
        System.out.println("Giá trị đọc được: " + value);
    }
}
