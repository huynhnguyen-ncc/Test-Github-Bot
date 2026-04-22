package PassingMechanism;

/**
 * Ví dụ nâng cao về cơ chế truyền tham số (Passing Mechanism).
 * - Java luôn là Pass-by-Value.
 * - Sự khác biệt khi truyền kiểu nguyên thủy (Primitive) vs kiểu tham chiếu (Reference).
 * - Cách làm việc với Wrapper Classes và tính bất biến của String.
 */
public class PassingMechanismAdvanced {

    public static void main(String[] args) {
        int x = 10;
        DataObj obj = new DataObj(50);

        System.out.println("Trước khi gọi phương thức: x = " + x + ", obj.val = " + obj.val);
        
        modify(x, obj);
        
        System.out.println("Sau khi gọi phương thức: x = " + x + ", obj.val = " + obj.val);
        
        // Giải thích:
        // x không đổi vì giá trị 10 được copy.
        // obj.val thay đổi vì địa chỉ vùng nhớ được copy, cả 2 tham chiếu cùng trỏ tới 1 đối tượng.
    }

    public static void modify(int a, DataObj b) {
        a = a + 100;
        b.val = b.val + 500;
        
        // Thử gán b bằng một đối tượng mới
        b = new DataObj(999); // Chỉ làm thay đổi tham chiếu cục bộ b, không ảnh hưởng đến obj gốc
    }
}

class DataObj {
    int val;
    DataObj(int v) { this.val = v; }
}
