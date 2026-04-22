package Static;

public class Outer {
    private int outerValue = 42;

    public class Inner {
        public void printOuter() {
            // Gọi ẩn: nhờ con trỏ ngầm, có thể dùng luôn tên field
            System.out.println("Implicit access: " + outerValue);
            // Gọi rõ ràng: chính là đối tượng Static.Outer đang “được” Inner sử dụng
            System.out.println("Explicit access: " + Outer.this.outerValue);
        }
    }

    public void test() {
        Inner in = new Inner();
        in.printOuter();
    }

    public static void main(String[] args) {
        new Outer().test();
    }
}
