package Interface;
// Lambda expression chỉ áp dụng cho interface
@java.lang.FunctionalInterface // Đánh dấu interface này là một functional interface (chỉ có một phương thức)
interface A3 {
//    void show(int i); // Functional interface không có giá trị trả về
    int add(int i, int j); // Functional interface có giá trị trả về
}
public class FunctionalInterface {
    public static void main(String[] args) {
//      Lambda expression để khởi tạo một cách ngắn gọn
//      Nếu có nhiều câu lệnh trong thân hàm, cần sử dụng dấu ngoặc nhọn
//        A3 obj = (int i) -> System.out.println("In show" + i);
//      Viết kiểu khác
//        A3 obj = i -> System.out.println("In show " + i);
//        obj.show(5);
        A3 obj = (i, j) -> i + j;
        int result = obj.add(5, 4);
        System.out.println(result);
    }
}
