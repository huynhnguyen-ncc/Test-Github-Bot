package Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListBenchmark {
    public static void main(String[] args) {
        // Các kích thước thử nghiệm
        int[] sizes = {1_000_000, 5_000_000, 10_000_000};

        for (int size : sizes) {
            System.out.println("----- Kích thước: " + size + " -----");
            benchmarkList(new ArrayList<Integer>(size), size, "ArrayList");
            benchmarkList(new LinkedList<Integer>(), size, "LinkedList");
            System.out.println();
        }
    }

    private static void benchmarkList(List<Integer> list, int size, String listName) {
        // Thời gian thêm phần tử
        long t0 = System.nanoTime();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long tAdd = System.nanoTime() - t0;

        // Thời gian truy xuất phần tử (lặp qua toàn bộ và tính tổng)
        long sum = 0;
        long t1 = System.nanoTime();
        for (int i = 0; i < size; i++) {
            sum += list.get(i);
        }
        long tGet = System.nanoTime() - t1;

        System.out.printf("%s: add time = %.3f s, get time = %.3f s (sum=%d)%n",
                listName,
                tAdd / 1e9,
                tGet / 1e9,
                sum);
/*
* Độ phức tạp cho phương thức add():
* - ArrayList là O(1) vì lưu trữ ở cuối danh sách, nhưng có thể O(n) nếu như chèn ở một vị trí nào đó trong mảng
* - LinkedList là O(1) vì chỉ cần cập nhật các con trỏ của nút mới và nút trước đó
* Độ phức tạp cho phương thức get():
* - ArrayList là O(1) vì có thể biết địa chỉ tuyệt đối của phần tử trong mảng
* - LinkedList là O(n) vì phải duyệt qua từng nút từ đầu đến cuối để tìm phần tử cần truy xuất
* */

    }
}
