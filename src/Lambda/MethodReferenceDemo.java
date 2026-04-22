package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class MethodReferenceDemo {
    // 1. Static method reference: ClassName::staticMethod
    //    Ví dụ: so sánh hai chuỗi không phân biệt hoa/thường
    public static boolean caseInsensitiveEquals(String a, String b) {
        return a.equalsIgnoreCase(b);
    }

    private String prefix;

    public MethodReferenceDemo(String prefix) {
        this.prefix = prefix;
    }

    // 2. Instance method reference của một object cụ thể: instance::method
    //    Ví dụ: thêm tiền tố đã cho trước vào chuỗi
    public String addPrefix(String s) {
        return prefix + s;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "bob", "Carol");

        // 1) Static method reference
        BiPredicate<String, String> eqIgnoreCase = MethodReferenceDemo::caseInsensitiveEquals;
        System.out.println("Compare Alice vs alice: " +
                eqIgnoreCase.test("Alice", "alice"));  // true

        // 2) Instance method reference của một object cụ thể
        MethodReferenceDemo decorator = new MethodReferenceDemo(">> ");
        Function<String, String> withPrefix = decorator::addPrefix;
        names.stream()
                .map(withPrefix)
                .forEach(System.out::println);
        // In ra:
        // >> Alice
        // >> bob
        // >> Carol

        // 3) Instance method reference của kiểu T (ClassName::instanceMethod)
        //    Ví dụ: gọi String::toUpperCase cho mỗi phần tử
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        // In ra:
        // ALICE
        // BOB
        // CAROL

        // 4) Constructor reference: ClassName::new
        //    Ví dụ: chuyển mỗi tên thành một StringBuilder mới
        Function<String, StringBuilder> makeBuilder = StringBuilder::new;
        List<StringBuilder> builders = names.stream()
                .map(makeBuilder)
                .toList();
        // Mỗi phần tử là một StringBuilder chứa chuỗi ban đầu
        builders.forEach(sb -> System.out.println(sb.reverse().toString()));
        // In ra (chuỗi đảo ngược):
        // ecilA
        // bob
        // loraC
    }
}
