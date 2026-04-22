package Collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapDemo {
//  Thay vì chỉ sử dụng index để truy cập phần tử trong mảng,
//  có thể đặt tên cho các index để dễ dàng truy cập hơn
//  Map là một tập hợp các cặp key-value, trong đó key là duy nhất và không trùng lặp
//  Map cũng không theo một trình tự nào cả, vì vậy không thể truy cập các phần tử theo index như trong mảng
//  Key được dùng để xác định địa chỉ của đối tượng nằm trong index nào trong vùng nhớ chứa index
//  Khi thêm phần tử vào Map, độ phức tạp trung bình là O(1) và độ phức tạp xấu nhất là O(n) vì phải kiểm tra xem key đã tồn tại hay chưa
    public static void main(String[] args) {
//      HashMap tương tự với HashTable, nhưng không đồng bộ
//      Nếu làm việc với nhiều luồng nhưng vẫn sử dụng HashMap, sử dụng từ khóa synchronized để đồng bộ hóa
        Map<String, Integer> students = new Hashtable<>();
        students.put("Nguyen", 56);
        students.put("Ba", 23);
        students.put("Hoang", 67);
        students.put("Huynh", 92);
        students.put("Ba", 45);
        System.out.println(students.get("Huynh"));

        System.out.println(students.keySet()); // In ra các key của Map
        for(String key: students.keySet()) {
            System.out.println(key + ": " + students.get(key));
        }
    }
}
