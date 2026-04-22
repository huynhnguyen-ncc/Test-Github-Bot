package Inner;
class A { // Lớp A có các biến và phương thức và lớp con
    int age;
    public void show() {
        System.out.println("In show");
    }
    static class B {
        public void config() {
            System.out.println("In config");
        }
    }
//  Khi khai báo lớp static bên trong một lớp, không cần phải có đối tượng của lớp A để tạo đối tượng của lớp B
//  Không thể biến lớp bên ngoài thành lớp static
}
public class Demo {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();

//      A.B obj1 = obj.new B(); // Lớp B là lớp con của lớp A, nên không thể tạo đối tượng B trực tiếp
//      Do đó, để gọi phương thức show() (từ lớp con non-static) của lớp B, cần phải có đối tượng A
        A.B obj1 = new A.B(); // Lớp B là lớp con static của lớp A, nên có thể tạo đối tượng B trực tiếp
        obj1.config();
    }
}
