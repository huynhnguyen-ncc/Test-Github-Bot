package Enum;

// Lớp enum Laptop
enum Laptop {
    Macbook(2000), XPS(2200), Surface, ThinkPad(1800);
//  Khi đưa ra các đối tượng trong enum, có thể cung cấp các tham số cho từng hằng số
//  Giả sử Laptop Surface không có giá, điều này sẽ gây ra lỗi
//  Vì vậy, cần phải tạo một contructor mặc định cho enum này
    private int price;

    private Laptop() {
        price = 500;
    }
//  Constructor này sẽ tạo ra 4 đối tượng

    private Laptop(int price) {
        this.price = price;
        System.out.println("In Laptop " + this.name());
    }
//  Constructor này sẽ tạo ra 3 đối tượng

//  Vì price là một thuộc tính private, cần có phương thức getter và setter để truy cập và thay đổi giá trị của nó
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
public class EnumClass {
    public static void main(String[] args) {
        Laptop lap = Laptop.Macbook;
        System.out.println(lap + ": " + lap.getPrice());

        for(Laptop x: Laptop.values()) {
            System.out.println(x + ": " + x.getPrice());
        }
    }
}
