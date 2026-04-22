package Collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachDemo {
    public static void main(String[] args) {
//      Thay vì thêm các giá trị bằng cách gọi add() nhiều lần, sử dụng một lớp Arrays và phương thức asList()
        List<Integer> nums = Arrays.asList(4, 5, 7, 3, 2, 6);
//      Mảng sẽ tự cung cấp giá trị và giá trị đó sẽ đi vào n
//        for(int n: nums) {
//            System.out.println(n);
//        }

        Consumer<Integer> con = n -> System.out.println(n);

//      forEach là một phương thức của interface List, được sử dụng để cung cấp từng giá trị một
//      Tham số truyền vào là một Consumer, có thể là một lambda expression
//      Consumer là một functional interface, có một phương thức duy nhất là accept()
        nums.forEach(con);
    }
}
