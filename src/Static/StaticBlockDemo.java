package Static;

import java.util.LinkedList;
import java.util.List;

public class StaticBlockDemo {
    public static List<String> ranks = new LinkedList<>();

    // Chỉ chạy 1 lần duy nhất khi class được nạp vào JVM
    static {
        System.out.println("Static block 1 chạy");
        ranks.add("Lieutenant");
        ranks.add("Captain");
    }
    // Chỉ chạy 1 lần duy nhất, ngay sau block trên
    static {
        System.out.println("Static block 2 chạy");
        ranks.add("Major");
        ranks.add("Colonel");
    }

    // Constructor không làm gì với ranks
    public StaticBlockDemo() {
        System.out.println("Constructor chạy");
    }

    public static void main(String[] args) {
        System.out.println("Bắt đầu chương trình");

        // Lần đầu new sẽ nạp lớp, chạy 2 static block, rồi constructor
        new StaticBlockDemo();
        // Lần thứ hai new chỉ chạy constructor, static block không chạy nữa
        new StaticBlockDemo();
        // In danh sách ranks
        System.out.println("ranks = " + StaticBlockDemo.ranks);
    }
}
