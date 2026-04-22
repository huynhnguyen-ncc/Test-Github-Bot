package Lambda;

import java.util.function.Predicate;

public class PredicateComposeDemo {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;        // kiểm tra số chẵn
        Predicate<Integer> isPositive = n -> n > 0;        // kiểm tra số dương

        // 1. and(): cả hai điều kiện đều phải đúng
        Predicate<Integer> isPositiveAndEven = isEven.and(isPositive);
        System.out.println("4 > 0 và chẵn? " + isPositiveAndEven.test(4));   // true
        System.out.println("-2 > 0 và chẵn? " + isPositiveAndEven.test(-2)); // false

        // 2. or(): ít nhất một trong hai điều kiện đúng
        Predicate<Integer> isPositiveOrEven = isEven.or(isPositive);
        System.out.println("3 > 0 hoặc chẵn? " + isPositiveOrEven.test(3));   // true (3 > 0)
        System.out.println("-4 > 0 hoặc chẵn? " + isPositiveOrEven.test(-4)); // true (-4 chẵn)
        System.out.println("-3 > 0 hoặc chẵn? " + isPositiveOrEven.test(-3)); // false

        // 3. negate(): đảo ngược kết quả
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println("5 là lẻ? " + isOdd.test(5));    // true
        System.out.println("6 là lẻ? " + isOdd.test(6));    // false
    }
}
