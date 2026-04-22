package Lambda;

import java.util.*;
import java.util.function.*;

/**
 * Ví dụ nâng cao về Lambda Expressions.
 * - Sử dụng các Functional Interfaces chuẩn (Predicate, Consumer, Function, Supplier).
 * - Method References: Cách viết ngắn gọn hơn cho Lambda.
 * - Variable Capture: Truy cập biến local trong Lambda (phải là effectively final).
 */
public class LambdaAdvancedDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java", "Spring", "Microservices", "Docker");

        // 1. Predicate: lọc dữ liệu
        Predicate<String> longName = s -> s.length() > 5;
        System.out.print("Tên dài hơn 5 ký tự: ");
        names.stream().filter(longName).forEach(System.out::print); // Method reference
        System.out.println();

        // 2. Function: biến đổi dữ liệu
        Function<String, Integer> nameLength = String::length;
        System.out.println("Độ dài các tên: ");
        names.stream().map(nameLength).forEach(len -> System.out.print(len + " "));
        System.out.println();

        // 3. Variable Capture
        String prefix = "Tech: ";
        // prefix = "Other"; // Nếu uncomment sẽ gây lỗi vì prefix không còn effectively final
        names.forEach(name -> System.out.println(prefix + name));
        
        // 4. Custom Functional Interface
        MathOp addition = (a, b) -> a + b;
        System.out.println("10 + 5 = " + addition.operate(10, 5));
    }
}

@FunctionalInterface
interface MathOp {
    int operate(int a, int b);
}
