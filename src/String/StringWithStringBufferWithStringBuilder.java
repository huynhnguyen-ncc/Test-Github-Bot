package String;

import java.util.GregorianCalendar;

public class StringWithStringBufferWithStringBuilder {
    private static final int ITERATIONS = 100_000;

    public static void main(StringDemo[] args) {
        // Chạy lần lượt 3 bài test
        runTestString();
        runTestStringBuffer();
        runTestStringBuilder();
    }

    private static void runTestString() {
        System.gc(); // Yêu cầu JVM dọn dẹp bộ nhớ trước khi bắt đầu
        long startTime   = new GregorianCalendar().getTimeInMillis();
        long startMemory = Runtime.getRuntime().freeMemory();

        // Test với phép nối String thuần túy
        String s = "";
        for (int i = 0; i < ITERATIONS; i++) {
            s = s + ":" + i;
        }

        long endTime   = new GregorianCalendar().getTimeInMillis();
        long endMemory = Runtime.getRuntime().freeMemory();

        System.out.println("=== String concat (+) ===");
        System.out.println("Time Taken: " + (endTime - startTime) + " ms");
        System.out.println("Memory used: " + (startMemory - endMemory) + " bytes");
        System.out.println();
    }

    private static void runTestStringBuffer() {
        System.gc();
        long startTime   = new GregorianCalendar().getTimeInMillis();
        long startMemory = Runtime.getRuntime().freeMemory();

        // Test với StringBuffer (thread-safe)
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            sb.append(":").append(i);
        }
        String result = sb.toString();

        long endTime   = new GregorianCalendar().getTimeInMillis();
        long endMemory = Runtime.getRuntime().freeMemory();

        System.out.println("=== StringBuffer ===");
        System.out.println("Time Taken: " + (endTime - startTime) + " ms");
        System.out.println("Memory used: " + (startMemory - endMemory) + " bytes");
        System.out.println();
    }

    private static void runTestStringBuilder() {
        System.gc();
        long startTime   = new GregorianCalendar().getTimeInMillis();
        long startMemory = Runtime.getRuntime().freeMemory();

        // Test với StringBuilder (không synchronized)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            sb.append(":").append(i);
        }
        String result = sb.toString();

        long endTime   = new GregorianCalendar().getTimeInMillis();
        long endMemory = Runtime.getRuntime().freeMemory();

        System.out.println("=== StringBuilder ===");
        System.out.println("Time Taken: " + (endTime - startTime) + " ms");
        System.out.println("Memory used: " + (startMemory - endMemory) + " bytes");
        System.out.println();
    }
}
