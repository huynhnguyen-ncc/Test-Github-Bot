package Enum;

enum Status {
    Running, Failed, Pending, Success; // Thay vì trả về định dạng String hoặc một đối tượng cụ thể, chỉ cần trả về các giá trị hằng
//  Chúng là các hằng số của enum Status
}
public class EnumDemo {
    public static void main(String[] args) {
        Status s = Status.Success;
        System.out.println(s.ordinal());
//      ordinal() trả về chỉ mục của hằng số trong enum, bắt đầu từ 0
        Status[] ss = Status.values();
//      values() trả về một mảng chứa tất cả các hằng số của enum theo thứ tự chúng được khai báo
        for(Status x: ss) {
            System.out.println(x + ": " + x.ordinal());
        }
    }
}
