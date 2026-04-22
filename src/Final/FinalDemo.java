package Final;

final class Calc {
    public void show() {
        System.out.println("In Calc show");
    }
    public void add(int a, int b) {
        System.out.println(a + b);
    }
}

public class FinalDemo {
    public static void main(String[] args) {
//      Biến final: Tạo ra hằng số
        final int num = 8;
        System.out.println(num);

//      Lớp final: Không thể kế thừa
        Calc obj = new Calc();
        obj.show();
        obj.add(4, 5);

//      Phương thức final: Không thể ghi đè
    }
}
