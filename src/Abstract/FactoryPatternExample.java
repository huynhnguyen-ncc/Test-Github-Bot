package Abstract;

/**
 * KẾ THỨC NÂNG CAO: Abstract Factory Pattern
 * Sử dụng abstract class để định nghĩa các sản phẩm chung và các
 * factory con để tạo ra các sản phẩm cụ thể. Đây là một ví dụ đơn giản
 * cho việc tạo các đối tượng "Vehicle" và "Engine".
 */
abstract class Vehicle {
    abstract void start();
    abstract Engine createEngine();
}

abstract class Engine {
    abstract void run();
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car started");
    }
    @Override
    Engine createEngine() {
        return new CarEngine();
    }
}

class CarEngine extends Engine {
    @Override
    void run() {
        System.out.println("Car engine running");
    }
}

class Bike extends Vehicle {
    @Override
    void start() {
        System.out.println("Bike started");
    }
    @Override
    Engine createEngine() {
        return new BikeEngine();
    }
}

class BikeEngine extends Engine {
    @Override
    void run() {
        System.out.println("Bike engine running");
    }
}

/**
 * Factory class để tạo Vehicle dựa trên type.
 */
class VehicleFactory {
    static Vehicle getVehicle(String type) {
        switch (type.toLowerCase()) {
            case "car": return new Car();
            case "bike": return new Bike();
            default: throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}

public class FactoryPatternExample {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle("car");
        car.start();
        car.createEngine().run();
        Vehicle bike = VehicleFactory.getVehicle("bike");
        bike.start();
        bike.createEngine().run();
    }
}
