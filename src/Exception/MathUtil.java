package Exception;

public class MathUtil {
    /**
     * Tính căn bậc hai; nếu tham số âm, ném IllegalArgumentException.
     */
    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Không thể tính căn bậc hai của số âm: " + x);
        }
        return Math.sqrt(x);
    }

    public static void main(String[] args) {
        double[] tests = { 9.0, -4.0, 16.0 };
        for (double t : tests) {
            try {
                System.out.println("sqrt(" + t + ") = " + sqrt(t));
            } catch (IllegalArgumentException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
    }
}
