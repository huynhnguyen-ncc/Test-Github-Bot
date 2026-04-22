package Interface;

class Calculator {
    public int add(int n1, int n2) {
        return n1 + n2;
    }
    public int add(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
    public double add(double n1, int n2) {
        return n1 + n2;
    }
//  Overloading cho phép các phương thức có cùng tên nhưng khác tham số
//  có thể là kiểu dữ liệu khác nhau, số lượng tham số khác nhau hoặc thứ tự tham số khác nhau
}
public class Overloading {
    public static void main(String[] args) {
        Calculator obj = new Calculator();
        int r1 = obj.add(3, 4);
        System.out.println(r1);
    }
}
