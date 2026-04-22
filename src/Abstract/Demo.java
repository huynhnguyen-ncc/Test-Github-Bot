package Abstract;

abstract class Car { // Phương thức trừu tượng drive trong lớp Car chỉ có thể được định nghĩa bởi một lớp trừu tượng
    public abstract void drive(); // Không biết cách triển khai phương thức drive, nếu không có phương thức drive thì không thể gọi là Car được => Chỉ cần khai báo abstract drive
    // Sử dụng abstract để đưa ý tưởng trừu tượng về một chiếc xe ô tô nên có tính năng drive, nhưng không biết cách triển khai nó
    public abstract void fly(); // Phương thức trừu tượng fly không cần thiết cho tất cả các loại xe ô tô, nhưng nếu có thì sẽ được triển khai trong các lớp con
    public void playMusic() { // Biết cách triển khai phương thức playMusic
        System.out.println("Playing music...");
    }
}
// LƯU Ý: Không thể tạo đối tượng từ lớp trừu tượng, nhưng có thể tham chiếu đến lớp trừu tượng
// Lớp trừu tượng vẫn có thể cài đặt các phương thức bình thường (không trừu tượng) như playMusic() trong ví dụ này

abstract class WagonR extends Car { // Tạo lớp WagonR để có thể triển khai phương thức drive
//  Khi lớp trừu tượng được thực thi bởi môt lớp con, lớp con phải triển khai tất cả các phương thức trừu tượng của lớp cha
//    public void fly() {
//        System.out.println("Flying...");
//    }
//  Nếu không triển khai phương thức fly thì có thể chuyển lớp WagonR thành lớp trừu tượng, tuy nhiên không thể tạo đối tượng WagonR nữa
    public void drive() {
        System.out.println("Driving...");
    }
}

class UpdatedWagonR extends WagonR { // Concrete class: Lớp cụ thể
    public void fly() {
        System.out.println("Flying...");
    }
}

public class Demo {
    public static void main(String[] args) {
//      Không thể tạo đối tượng Car vì nó là lớp trừu tượng, nhưng có thể tham chiếu đến lớp trừu tượng Car
        Car obj = new UpdatedWagonR();
        obj.drive();
        obj.playMusic();
        obj.fly();
    }
}
// --------- Advanced Concepts: Constructors in Abstract Classes ---------
/*
 * Khi một abstract class có constructor, constructor sẽ được gọi
 * khi một lớp con khởi tạo, cho phép khởi tạo các trường chung.
 */
abstract class Computer {
    String brand;
    public Computer(String brand) {
        this.brand = brand;
        System.out.println("Computer Constructor called for: " + brand);
    }
}
class Laptop extends Computer {
    public Laptop(String brand) {
        super(brand);
    }
}

// Có bắt buộc phải tạo phương thuức trừu tượng trong lớp trừu tượng không?
// Không bắt buộc phải tạo phương thức trừu tượng trong lớp trừu tượng.

/*
Kết luận:
- Từ khóa abstract có thể được sử dụng với các phương thức nếu muốn khai báo chúng
- Nếu có bất kỳ phương thức trừu tượng nào, cần phải tạo một lớp trừu tượng
- Nếu có lớp trừu tượng, không bắt buộc lớp trừu tượng phải có phương thức trừu tượng
- Không thể tạo đối tượng từ lớp trừu tượng
- Nếu muốn tạo một đối tượng, phải có một lớp con thực hiện tất cả các phương thức trừu tượng của lớp cha
 */