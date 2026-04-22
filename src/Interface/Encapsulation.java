package Interface;

/*
* Ví dụ về tính đóng gói: Viên nang chứa thuốc bột, không ai biết bên trong viên nang có gì, chỉ biết rằng khi uống vào sẽ khỏi bệnh
* Ví dụ: Nếu có ai đó muốn biết dữ liệu bên trong não của bạn, họ phải hỏi và bạn có thể quyết định có cho họ biết hay không
* */
class Human {
    private int age = 11; //  Biến age là biến thành viên của lớp Human
//  Không thể truy cập trực tiếp từ bên ngoài
//  Mỗi khi khai báo biến, nên khai báo private để bảo vệ dữ liệu
    private String name = "Huynh";

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

//  Trong trường hợp biến cục bộ và biến thành viên có cùng tên, biến cục bộ sẽ được ưu tiên
//  Ví dụ: Nếu như gán giá trị 22 cho biến cục bộ age (age = age) trong phương thức setAge(int a) thì in ra giá trị 0
//  Bởi vì biến age ở vế trái là biến cục bộ hoặc biến thành viên (biến age tự gán cho chính nó)
//  Sự ưu tiên của biến cục bộ so với biến thành viên trong phương thức là một quy tắc trong Java
//  Để khẳng định biến age ở vế trái là biến thành viên

/*
* Trong phương thức này, tạo một đối tượng mới
* Không nên tạo đối tượng mới vì sẽ tạo đối tượng mới trong vùng nhớ heap, gán giá trị age là 22
* Nhưng chỉ thực hiện tạo đối tượng trong phương thức setAge(), chứ không phải trong phương thức main()
* */
//    public void setAge(int a) { // Biến a là biến cục bộ
//        Human obj1 = new Human();
//        obj1.age = a;
//    }

/*
* Một cách khác là thêm tham số đối tượng vào phương thức setAge để truyền tham chiếu đến đối tượng obj
* */
    public void setAge(int a, Human obj) { // Biến a là biến cục bộ
        Human obj1 = obj;
        obj1.age = a;
    }

/*
* Từ khóa this đại diện cho đối tượng hiện tại đang gọi phương thức */
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String n) {
        name = n;
    }
}
public class Encapsulation {
    public static void main(String[] args) {
        Human obj = new Human();
//        obj.age = 11;
//        obj.name = "Huynh";
        obj.setAge(22, obj);
        obj.setName("Huynh Nguyen");

        System.out.println(obj.getName() + " " + obj.getAge());
    }
}
