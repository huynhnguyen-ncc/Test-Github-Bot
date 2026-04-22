package Collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 7, 3, 2, 6);

        Stream<Integer> s1 = nums.stream();

/* Phương thức stream cung cấp đối tượng của Stream
* Stream cho phép thực hiện bất kỳ thao tác nào không ảnh hưởng đến các con số
* Dù có thao tác trên nums nhưng không ảnh hưởng đến các giá trị của nums
* Một khi đã sử dụng stream thì không thể sử dụng lại nó nữa */

//      filter là một phương thức của Stream, được sử dụng để lọc các giá trị trong stream, trả về một stream
//      filter nhận một đối tượng Predicate, Predicate là một functional interface, có một phương thức duy nhất là test() trả về giá trị boolean
        Stream<Integer> s2 = s1.filter(n -> n % 2 == 0); // Lọc các số chẵn
//      Triển khai Predicate
        Predicate<Integer> p1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                if(n%2==0) {
                    return true; // Trả về true nếu n là số chẵn
                } else {
                    return false; // Trả về false nếu n là số lẻ
                }
            }
        };
//      Cách viết ngăn gọn
        Predicate<Integer> p2 = n -> n % 2 == 0; // Lọc các số chẵn


//      Trong map, với bất kỳ giá trị nào trong stream, có thể thao tác trên nó và trả về một giá trị mới
//      map cần đối tượng Function, Function là một functional interface, có một phương thức duy nhất là apply()
        Stream<Integer> s3 = s2.map(n -> n * 2); // Nhân đôi các số chẵn
        Function<Integer, Integer> fun = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n * 2; // Nhân đôi giá trị n
            }
        };
//      Cách viết ngắn gọn
        Function<Integer, Integer> fun2 = n -> n * 2; // Nhân đôi giá trị n


//      reduce là một phương thức của Stream, được sử dụng để tính toán một giá trị duy nhất từ các giá trị trong stream
//      reduce nhận hai tham số: giá trị khởi tạo và một đối tượng BinaryOperator, BinaryOperator là một functional interface
//      BinaryOperator kế thừa từ BiFunction, BiFunction là một functional interface, có hai tham số đầu vào và một giá trị trả về, có một phương thức duy nhất là apply()
//      Trong trường hợp cộng 4 số, cộng giá trị khởi tạo với từng giá trị trong stream
//      c là số nhớ, e là element trong stream
        int result = s3.reduce(0, (c, e) -> c + e); // Tính tổng các số chẵn đã nhân đôi

//      Cách viết ngắn gọn
        int result2 = nums.stream()
                        .filter(n -> n % 2 == 0)
                                .map(n -> n * 2)
                                        .reduce(0, (c, e) -> c + e);

        Stream<Integer> sortedValues = nums.stream()
                        .filter(n -> n % 2 == 0)
                                .sorted();


        System.out.println(result);
        System.out.println(result2);
//        s3.forEach(n -> System.out.println(n));
//        s1.forEach(n -> System.out.println(n)); Không thể sử dụng lại stream đã được sử dụng
        sortedValues.forEach(n -> System.out.println(n)); // In ra các số chẵn đã sắp xếp
    }
}
