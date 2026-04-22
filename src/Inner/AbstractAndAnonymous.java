package Inner;

abstract class A3 {
    public abstract void show();
    public abstract void config();
}
//class B3 extends A3 {
//    @Override
//    public void show() {
//        System.out.println("In B show");
//    }
//}
public class AbstractAndAnonymous {
    public static void main(String[] args) {
        A3 obj = new A3(){
            public void show() {
                System.out.println("In new show");
            }
            public void config() {
                System.out.println("In config");
            }
        };
//      Tại sao lại có thể khởi tạo đối tượng của lớp trừu tượng trong trường hợp này?
//      Lớp ẩn danh này cung cấp phần triển khai cho lớp trừu tượng
//      Thực tế, đang tạo đối tượng của lớp ẩn danh kế thừa từ lớp trừu tượng A3.
        obj.show();
    }
}
