package Exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {

    /**
     * Đọc toàn bộ nội dung của file và trả về dưới dạng chuỗi.
     * Phương thức khai báo throws IOException để “đẩy” việc xử lý lỗi cho caller.
     */
    public static String readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } finally {
            reader.close();
        }
    }

    public static void main(String[] args) {
        try {
            String content = readFile("data.txt");
            System.out.println(content);
        } catch (IOException e) {
            // Bắt và xử lý khi không đọc được file
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
