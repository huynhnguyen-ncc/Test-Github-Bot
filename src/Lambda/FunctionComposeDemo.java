package Lambda;

import java.util.function.Function;

public class FunctionComposeDemo {
    public static void main(String[] args) {
        // Hàm nhân đôi
        Function<Integer, Integer> multiplyBy2 = x -> x * 2;
        // Hàm cộng 3
        Function<Integer, Integer> add3        = x -> x + 3;

        // 1. andThen: (x * 2) rồi +3
        Function<Integer, Integer> times2ThenPlus3 = multiplyBy2.andThen(add3);
        System.out.println(times2ThenPlus3.apply(5));  // (5 * 2) + 3 = 13

        // 2. compose: +3 rồi (x * 2)
        Function<Integer, Integer> plus3ThenTimes2 = multiplyBy2.compose(add3);
        System.out.println(plus3ThenTimes2.apply(5));  // (5 + 3) * 2 = 16

        // 3. identity: trả về chính đầu vào
        Function<String, String> id = Function.identity();
        System.out.println(id.apply("Hello"));         // "Hello"
    }
}