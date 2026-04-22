package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStream {
    public static void main(String[] args) {
        int size = 10_000;
        List<Integer> nums = new ArrayList<>(size); // Mảng 10000 số 0
        Random ran = new Random();
        for(int i = 1; i <= size; i++) {
            nums.add(ran.nextInt(100)); // Thêm số ngẫu nhiên từ 0 đến 99
        }

        int sum1 = nums.stream()
                .map(i -> i * 2) // Nhân đôi từng phần tử
                .reduce(0, (c, e) -> c + e); // Tính tổng

//      Không thể sử dụng phương thức sum() cho Stream<Integer> vì nó không có phương thức sum()
//      MapToInt() sẽ chuyển đổi Stream<Integer> thành IntStream
//      MapToInt() có sẳn phương thức sum() để tính tổng các phần tử trong IntStream
//      currentTimeMillis() sẽ trả về thời gian hiện tại tính bằng mili giây kể từ 1/1/1970
        long startSeq = System.currentTimeMillis();
        int sum2 = nums.stream()
                .mapToInt(i -> i) // Chuyển đổi thành IntStream
                .sum(); // Tính tổng
        long endSeq = System.currentTimeMillis();

        long startPara = System.currentTimeMillis();
        int sum3 = nums.parallelStream()
                .map(i -> i * 2) // Nhân đôi từng phần tử
                .mapToInt(i -> i) // Chuyển đổi thành IntStream
                .sum(); // Tính tổng
        long endPara = System.currentTimeMillis();
//      Về tốc độ: Luồng song song sẽ mất nhiều thời gian hơn luồng tuần tự
//      Bởi vì luồng song song có trách nhiệm tạo ra các luồng con và quản lý chúng
        System.out.println(sum2 + " " + sum3);
        System.out.println("Seq: " + (endSeq - startSeq) + " ms");
        System.out.println("Seq: " + (endPara - startPara) + " ms");
    }
}
