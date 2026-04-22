package Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
//  List chứa các phần tử trùng lặp, Set không chứa các phần tử trùng lặp
//  Set không theo trình tự, chứa các giá trị theo định dạng đã được sắp xếp
//  Khi thêm phần tử vào Set, độ phức tạp trung bình là O(1) và độ phức tạp xấu nhất là O(n) vì phải kiểm tra xem phần tử đã tồn tại hay chưa
    public static void main(String[] args) {
        Set<Integer> nums = new TreeSet<Integer>();
        nums.add(62);
        nums.add(54);
        nums.add(82);
        nums.add(21);
        nums.add(62); // Phần tử trùng lặp sẽ không được thêm vào

//      iterator() trả về một đối tượng Iterator, cho phép duyệt qua các phần tử của Collection
        Iterator<Integer> values = nums.iterator();
//      hasNext() kiểm tra xem còn phần tử tiếp theo trong Collection hay không
        while(values.hasNext()) {
            System.out.println(values.next());
        }

//  Set không có phương thức get(index), vì vậy không thể truy cập trực tiếp theo chỉ mục
//  Để có một danh sách các phần tử được sắp xếp, sử dụng TreeSet
//  Vì TreeSet kế thừa interface AbstractSet và AbstractSet kế thừa interface SortedSet

        for(int n: nums) {
            System.out.println(n);
        }
    }
}
