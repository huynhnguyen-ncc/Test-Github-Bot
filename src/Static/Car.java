package Static;

public class Car {
    private String name;
    private String engine;
    public int numberOfCars;    // không static

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }

    public static void main(String[] args) {
        Car car1 = new Car("Jaguar", "V8");
        Car car2 = new Car("Bugatti", "W16");
        System.out.println(car1.numberOfCars); // in ra 1
        System.out.println(car2.numberOfCars); // in ra 1
    }
}