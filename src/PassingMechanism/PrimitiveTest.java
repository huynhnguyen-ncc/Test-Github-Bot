package PassingMechanism;

public class PrimitiveTest {
    public static void main(String[] args) {
        int x = 1;
        System.out.println("Trước: x = " + x);  // 1
        modify(x);
        System.out.println("Sau:  x = " + x);    // vẫn 1
    }
    static void modify(int value) {
        value = 100;  // chỉ thay đổi bản sao
    }
}
