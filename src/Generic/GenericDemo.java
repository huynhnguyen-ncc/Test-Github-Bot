package Generic;

import java.util.ArrayList;
import java.util.List;

// 1. Generic Class: Box<T>: Lớp này có thể chứa bất kỳ kiểu dữ liệu nào
class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Box[" + value + "]";
    }
}

public class GenericDemo {

    public static void main(String[] args) {
        // Sử dụng Generic Class
        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> intBox = new Box<>(123);

        System.out.println(stringBox); // Box[Hello]
        System.out.println(intBox);    // Box[123]

        // 2. Generic Method
        Integer[] intArray    = { 1, 2, 3, 4, 5 };
        String[]  strArray    = { "A", "B", "C" };
        printArray(intArray);
        printArray(strArray);

        // 3. Bounded Type Parameter: chỉ cho các lớp con của Number
        List<Integer> nums = List.of(10, 20, 30);
        System.out.println("Sum = " + sumList(nums)); // Sum = 60.0

        // 4. Wildcards
        List<Double> doubles = List.of(1.1, 2.2, 3.3);
        printNumbers(doubles);  // dùng ? extends Number

        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);   // dùng ? super Integer
        System.out.println("Numbers after addIntegers: " + numbers);
    }

    // Phương thức generic cho mọi kiểu mảng
    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Bounded type parameter: T phải là Number hoặc subclass của Number
    public static <T extends Number> double sumList(List<T> list) {
        double sum = 0;
        for (T num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    // Wildcard ? extends Number: chỉ đọc (get) được các đối tượng Number, không thể thêm vào danh sách
    public static void printNumbers(List<? extends Number> list) {
        System.out.print("Numbers: ");
        for (Number n : list) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Wildcard ? super Integer: chỉ thêm được Integer hoặc subclass của Integer vào danh sách
    public static void addIntegers(List<? super Integer> list) {
        list.add(100);
        list.add(200);
    }
}
