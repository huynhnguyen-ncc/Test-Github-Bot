package Inner;

class A2 {
    public void show() {
        System.out.println("In A show");
    }
}
class B2 extends A2 { // Tạo lớp B2 kế thừa từ A2 để ghi đè phương thức show. Lớp này chỉ được sử dụng một lần
    public void show() {
        System.out.println("In B show");
    }
}
public class Anonymous {
    public static void main(String[] args) {
//        A2 obj = new A2();
//        obj.show();
        A2 obj2 = new B2(); // Tạo đối tượng B2 nhưng tham chiếu bằng A2
//        Câu lệnh này tạo một đối tượng của lớp B2 trên vùng nhớ heap
//        Biến obj2 là một biến tham chiếu nằm trên stack và nó mang địa chỉ trỏ đến vị trí của đối tượng B2 đó trn heap
//        Mọi B2 đều là một A2 (is-a relationship)
//        Mối quan hệ kế thừa cho phép gán một đối tượng lớp con cho biến kiểu lớp cha
//        Không thể gán ngược lại vì A2 không chứa phần mở rộng (override) hay trạng thái nào của B2
//        A2 obj = new A2()
//        {
//            public void show() {
//                System.out.println("In new show");
//            }
//        };
//        obj.show();
        obj2.show();
//      Tạo đối tượng obj nhưng sử dụng lớp ẩn danh kế thừa từ A2
    }
}
