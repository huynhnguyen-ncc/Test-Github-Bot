package PassingMechanism;

class Foo {
    public int num;
    public Foo(int n) { num = n; }
}
public class ReferenceTest {
    public static void main(String[] args) {
        Foo a = new Foo(1);
        Foo b = new Foo(1);
        System.out.println("Trước sửa: a.num=" + a.num + ", b.num=" + b.num);
        modify(a, b);
        System.out.println("Sau sửa:   a.num=" + a.num + ", b.num=" + b.num);
    }
    static void modify(Foo x, Foo y) {
        x.num++;            // tăng num của đối tượng mà x trỏ tới ⇒ thay đổi thấy được
        y = new Foo(5);     // gán y trỏ đến PassingMechanism.Foo mới ⇒ biến b ngoài không đổi
        y.num = 10;         // chỉ thay đổi đối tượng mới, không ảnh hưởng b
    }
}
