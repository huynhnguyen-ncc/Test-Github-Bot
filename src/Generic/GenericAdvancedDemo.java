package Generic;

import java.util.*;

/**
 * Ví dụ nâng cao về Generics.
 * - Bounded Type Parameters (Upper Bounds).
 * - Wildcards (Upper Bounds & Lower Bounds).
 * - Generic Methods và Type Inference.
 */
public class GenericAdvancedDemo {

    // Generic Method với Upper Bound
    public static <T extends Number> double sumOfList(List<T> list) {
        double s = 0.0;
        for (T n : list) s += n.doubleValue();
        return s;
    }

    // Wildcard với Upper Bound (? extends T) - Chỉ đọc (Producer)
    public static void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Wildcard với Lower Bound (? super T) - Chỉ ghi (Consumer)
    public static void addIntegers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("Tổng Integer: " + sumOfList(li));

        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("Tổng Double: " + sumOfList(ld));

        List<Number> numList = new ArrayList<>();
        addIntegers(numList);
        System.out.print("Danh sách sau khi thêm Integer: ");
        printNumbers(numList);
    }
}
