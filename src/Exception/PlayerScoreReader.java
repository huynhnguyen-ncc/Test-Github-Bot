package Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerScoreReader {
    private static final Logger logger = Logger.getLogger(PlayerScoreReader.class.getName());

    /**
     * Cách 1: Bắt FileNotFoundException và ném tiếp dưới dạng IllegalArgumentException.
     * Ai gọi phương thức này phải sẵn sàng chịu IllegalArgumentException nếu file không tồn tại.
     */
    public int getPlayerScoreOrThrow(String playerFile) {
        try (Scanner contents = new Scanner(new File(playerFile))) {
            return Integer.parseInt(contents.nextLine());
        } catch (FileNotFoundException e) {
            // Bọc và ném thành unchecked exception
            throw new IllegalArgumentException("File không tìm thấy: " + playerFile, e);
        }
    }

    /**
     * Cách 2: Bắt FileNotFoundException, ghi log, trả về mặc định 0.
     * Caller không cần phải bắt ngoại lệ, vì đã xử lý bên trong.
     */
    public int getPlayerScoreOrDefault(String playerFile) {
        try (Scanner contents = new Scanner(new File(playerFile))) {
            return Integer.parseInt(contents.nextLine());
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "File không tìm thấy, đặt score về 0: " + playerFile, e);
            return 0;
        }
    }

    public static void main(String[] args) {
        PlayerScoreReader reader = new PlayerScoreReader();

        String existingFile = "players.txt";
        String missingFile  = "unknown.txt";

        // Ví dụ 1: getPlayerScoreOrThrow
        try {
            int score = reader.getPlayerScoreOrThrow(existingFile);
            System.out.println("Score (orThrow): " + score);
            // Thử với file không tồn tại
            reader.getPlayerScoreOrThrow(missingFile);
        } catch (IllegalArgumentException e) {
            System.err.println("Lỗi (orThrow): " + e.getMessage());
        }

        // Ví dụ 2: getPlayerScoreOrDefault
        int scoreDefault1 = reader.getPlayerScoreOrDefault(existingFile);
        System.out.println("Score (orDefault): " + scoreDefault1);

        int scoreDefault2 = reader.getPlayerScoreOrDefault(missingFile);
        System.out.println("Score (orDefault): " + scoreDefault2);
    }
}
