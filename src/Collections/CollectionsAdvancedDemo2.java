package Collections;

import java.util.*;
import java.util.concurrent.*;

/**
 * Ví dụ nâng cao về Collections.
 * - Sử dụng ConcurrentHashMap để đảm bảo an toàn đa luồng.
 * - Sử dụng Collections.unmodifiableList để bảo vệ dữ liệu.
 * - Minh họa sự khác biệt giữa Fail-Fast và Fail-Safe iterator.
 */
public class CollectionsAdvancedDemo2 {
    public static void main(String[] args) {
        // 1. ConcurrentHashMap (Fail-Safe)
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("Java", 1);
        concurrentMap.put("Python", 2);

        System.out.println("ConcurrentHashMap ban đầu: " + concurrentMap);

        // 2. Unmodifiable List
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        System.out.println("Unmodifiable List: " + unmodifiableList);
        // unmodifiableList.add("D"); // Sẽ gây lỗi UnsupportedOperationException

        // 3. Demo EnumSet - tối ưu hiệu suất cho tập hợp các Enum
        enum Status { NEW, RUNNING, FINISHED }
        Set<Status> statusSet = EnumSet.of(Status.NEW, Status.RUNNING);
        System.out.println("EnumSet: " + statusSet);

        // 4. PriorityQueue với Comparator tùy chỉnh
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(Arrays.asList(10, 30, 20));
        System.out.println("PriorityQueue (giảm dần): " + pq.poll() + ", " + pq.poll() + ", " + pq.poll());
    }
}
