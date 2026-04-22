package Static;

public class StaticLabel {
    private String name;
    private String engine;
    public static int numberOfCars;

    public StaticLabel(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;  // Mỗi lần khởi tạo Static.Car mới, biến tĩnh tăng lên 1
    }

    public static void main(String[] args) {
        new StaticLabel("Jaguar", "V8");
        new StaticLabel("Bugatti", "W16");
        // In ra để kiểm tra
        System.out.println("Tổng số Static.Car đã khởi tạo: " + StaticLabel.numberOfCars);
    }

}
