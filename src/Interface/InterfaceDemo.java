package Interface;

// Class - Class ==> Extends
// Class - Interface ==> Implements
// Interface - Interface ==> Extends

interface A {
//  Có thể khởi tạo các biến trong interface, nhưng chúng sẽ là hằng số (public static final)
//  Tại sao các biến trong interface là static final?
//  - Static: Vì interface không thể được khởi tạo. Bất cứ thứ gì được khởi tạo đều là một lớp (không extends mà là implements)
//  Những gì nhận được trong implements chỉ là các phương thức, không phải biến
//  - Final: Vì các biến trong interface không có bộ nhớ riêng trong heap
    int age = 44;
    String area = "Hà Nội";
    void show();
    void config();
}
// Khi có một lớp chỉ có các phương thức trừu tượng, giải pháp thay thế là tạo một interface
// Interface không phải là một lớp. Mặc định, mọi phương thức trong interface đều là public abstract
// Do đó, không cần khai báo từ khóa public abstract trước mỗi phương thức
// Giống như lớp trừu tượng, interface không thể được khởi tạo trực tiếp
// Cần tạo ra interface để có thể thiết kế các phương thức mà không cần cài đặt

// Ví dụ: Nếu ai đó hỏi bạn cách đến một địa điểm, bạn có thể trả lời: "Đi thẳng, rẽ trái, rẽ phải, đi ô tô, đi bộ"
// Bạn phải chỉ cho họ cách đi (tức là cho người đó bản thiết kế), không thể đi đến đó thay họ
// Tương tự, interface chỉ cung cấp bản thiết kế cho các phương thức mà không cài đặt chúng

// Đối với một lớp kế thừa một lớp trừu tượng, nó sử dụng từ khóa extends
// Đối với một lớp cài đặt một interface, nó sử dụng từ khóa implements
// Cần phải triển khai tất cả các phương thức trong interface, nếu không lớp này sẽ trở thành lớp trừu tượng

interface X {
    void run();
}

// Một interface có thể kế thừa từ nhiều interface khác
interface Y extends X{

}

// Một lớp có thể implements nhiều interface, nhưng chỉ có thể extends một lớp
// Một lớp phải trển khai tất cả các phương thức từ các interface mà nó implements, kể cả các phương thức từ các interface mà nó kế thừa
class B implements A, Y {
    @Override
    public void show() {
        System.out.println("In show");
    }

    @Override
    public void config() {
        System.out.println("In config");
    }


    @Override
    public void run() {
        System.out.println("Running...");
    }
}
public class InterfaceDemo {
    public static void main(String[] args) {
        A obj; // Khai báo một biến tham chiếu của A, nhưng không khởi tạo nó
        obj = new B(); // Khởi tạo đối tượng B và gán cho biến obj
        obj.show();
        obj.config();

//      Khi tạo một biến kiểu của interface A và đối tượng của lớp B, chỉ có thể gọi các phương thức trong interface A
//      Nếu gọi phương thức run() sẽ báo lỗi vì phương thức này không có trong interface A
//      Nếu muốn gọi phương thức run(), cần tạo một biến tham chiếu của interface X

        X obj1 = new B();
        obj1.run();

//      Có thể sử dụng trực tiếp các biến trong interface
        System.out.println(A.age);
    }
}
