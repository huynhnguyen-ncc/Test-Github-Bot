package Lambda;

import java.util.*;
import java.util.function.Predicate;

public class BehaviorParamDemo {

    // Hàm chung để lọc danh sách theo điều kiện do caller cung cấp
    public static <T> List<T> filterList(List<T> list, Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (condition.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-5, -2, 0, 1, 4, 7, 10);

        // 1. Lọc số chẵn
        Predicate<Integer> isEven = n -> n % 2 == 0;
        List<Integer> evens = filterList(numbers, isEven);
        System.out.println("Chẵn: " + evens);  // [ -2, 0, 4, 10 ]

        // 2. Lọc số dương
        Predicate<Integer> isPositive = n -> n > 0;
        List<Integer> positives = filterList(numbers, isPositive);
        System.out.println("Dương: " + positives);  // [ 1, 4, 7, 10 ]

        // 3. Lọc số lớn hơn 5
        List<Integer> greaterThanFive = filterList(numbers, n -> n > 5);
        System.out.println(">5: " + greaterThanFive);  // [ 7, 10 ]
    }
}