package Final;

import java.util.*;

/**
 * Ví dụ nâng cao về từ khóa 'final'.
 * - Tạo lớp bất biến (Immutable Class).
 * - Sử dụng 'final' để bảo vệ tính toàn vẹn của dữ liệu trong đa luồng.
 * - Minh họa 'final' tham chiếu vs 'final' nội dung.
 */
public final class FinalAdvancedDemo { // Lớp final: không thể kế thừa
    private final String id;
    private final List<String> tags; // Danh sách final tham chiếu

    public FinalAdvancedDemo(String id, List<String> tags) {
        this.id = id;
        // Thủ thuật tạo tính bất biến: copy dữ liệu thay vì gán tham chiếu trực tiếp
        this.tags = Collections.unmodifiableList(new ArrayList<>(tags));
    }

    public String getId() {
        return id;
    }

    // Trả về một bản copy hoặc unmodifiable list để đảm bảo tính bất biến
    public List<String> getTags() {
        return tags;
    }

    public static void main(String[] args) {
        List<String> myTags = new ArrayList<>(Arrays.asList("Java", "Spring"));
        FinalAdvancedDemo demo = new FinalAdvancedDemo("001", myTags);

        System.out.println("ID: " + demo.getId());
        System.out.println("Tags: " + demo.getTags());

        // demo.getTags().add("New"); // Sẽ gây lỗi UnsupportedOperationException
        
        myTags.add("Broken?"); // Không ảnh hưởng đến dữ liệu bên trong demo
        System.out.println("Tags sau khi sửa list gốc: " + demo.getTags());
    }
}
