package Exception;

public class ArrayDemo {
    public static int getElement(int[] arr, int idx) {
        // Nếu idx < 0 hoặc >= arr.length, JVM tự ném ArrayIndexOutOfBoundsException
        return arr[idx];
    }

    public static void main(String[] args) {
        int[] data = { 10, 20, 30 };
        System.out.println(getElement(data, 1));  // in 20
        try{
            System.out.println(getElement(data, 5));  // ném ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}
