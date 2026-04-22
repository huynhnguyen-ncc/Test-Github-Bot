package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
//      Collection là một interface trong Java đại diện cho một nhóm các đối tượng
//      Cần phải chỉ rõ kiểu dữ liệu của Collection
//      Nếu không chỉ rõ kiểu dữ liệu, Collection sẽ chứa các đối tượng kiểu Object
//      ArrayList là một lớp trong Java triển khai giao diện List, cung cấp một mảng động để lưu trữ các phần tử
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(6);
        nums.add(5);
        nums.add(8);
        nums.add(2);
//      ArrayList là một lớp, có phương thức get() vì List hoạt động với các giá trị index

//      In một mảng
        System.out.println(nums.get(2));
        System.out.println(nums.indexOf(2)); // Trả về vị trí của phần tử đầu tiên có giá trị 2
//        for(int n: nums) {
//            System.out.println(n);
//        }
        for(Object n: nums) {
            System.out.println((Integer)n * 2);
        }
    }
}
