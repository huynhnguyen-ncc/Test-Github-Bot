package String;

/**
 * Ví dụ nâng cao về String.
 * - String Pool và cơ chế Interning.
 * - StringBuilder vs StringBuffer (Thread-safety).
 * - Tối ưu hóa việc nối chuỗi trong Java hiện đại.
 * - Sử dụng Text Blocks (Java 15+).
 */
public class StringAdvancedDemo {
    public static void main(String[] args) {
        // 1. String Pool & Interning
        String s1 = "Java";
        String s2 = new String("Java");
        String s3 = s2.intern(); // Đưa vào pool nếu chưa có và trả về tham chiếu từ pool

        System.out.println("s1 == s2: " + (s1 == s2)); // false
        System.out.println("s1 == s3: " + (s1 == s3)); // true

        // 2. StringBuilder: nhanh hơn cho các thao tác chuỗi đơn luồng
        StringBuilder sb = new StringBuilder("Học");
        sb.append(" Java").append(" thật").append(" thú").append(" vị");
        System.out.println("StringBuilder: " + sb.toString());

        // 3. Text Blocks (Cú pháp hiện đại cho chuỗi nhiều dòng)
        String json = """
                {
                    "name": "Java",
                    "version": "17",
                    "type": "Programming Language"
                }
                """;
        System.out.println("JSON Format:\n" + json);
    }
}
