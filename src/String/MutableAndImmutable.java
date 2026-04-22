package String;

public class MutableAndImmutable {
    public static void main(String[] args) {
        String name = "huynh";
        name = name + " Nguyen";
//      Khi cộng chuỗi, String Pool sẽ tạo ra một đối tượng String mới
//      Khi đó, đối tượng cũ "huynh" có thể sẽ bị thu hồi bộ nhớ nếu không còn tham chiếu nào đến nó
        System.out.println("Hello " + name);

        String s1 = "Huynh";
        String s2 = "Huynh";
//      s1 và s2 không trỏ đến hai đối tượng khác nhau
//      Cụ thể, có một vùng nhớ đặc biệt trong JVM gọi là String Pool
//      Mỗi chuỗi được tạo ra sẽ được lưu trữ trong String Pool
//      Không thể thay đổi nội dung của chuỗi đã được lưu trữ trong String Pool
//      Chuỗi hằng "Huynh" được lưu trữ trong String Pool
//      Hai biến s1 và s2 đều trỏ đến cùng chuỗi "Huynh" trong String Pool

//      String mặc định là immutable. Một khi đã tạo ra một chuỗi, không thể thay đổi nội dung của nó
    }
}
