package Static;

public class StaticMethod {
    private String name;
    private String engine;
    public static int numberOfCars;  // biến tĩnh đếm số xe

    public StaticMethod(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;  // Mỗi lần khởi tạo Static.Car mới thì tăng biến tĩnh lên 1
    }

    // Phương thức tĩnh cho phép gán trực tiếp cho biến tĩnh
    public static void setNumberOfCars(int n) {
        StaticMethod.numberOfCars = n;
    }

    public static void main(String[] args) {
        // Khởi tạo 2 đối tượng Static.Car, biến numberOfCars hiện là 2
        new StaticMethod("Jaguar", "V8");
        new StaticMethod("Bugatti", "W16");
        System.out.println("Tổng số Static.Car đã khởi tạo: " + StaticMethod.numberOfCars);

        // Gọi phương thức tĩnh để thiết lập lại giá trị
        StaticMethod.setNumberOfCars(10);
        System.out.println("Sau khi gọi setNumberOfCars(10): " + StaticMethod.numberOfCars);
    }
}