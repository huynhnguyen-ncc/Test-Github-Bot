package Enum;

/**
 * Ví dụ nâng cao về Enum.
 * - Enum với các trường dữ liệu và phương thức.
 * - Triển khai Interface trong Enum.
 * - Sử dụng Enum như một Strategy Pattern.
 */
interface Operation {
    double apply(double x, double y);
}

public enum EnumAdvancedDemo implements Operation {
    ADD("+") {
        public double apply(double x, double y) { return x + y; }
    },
    SUBTRACT("-") {
        public double apply(double x, double y) { return x - y; }
    },
    MULTIPLY("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    EnumAdvancedDemo(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Toán tử: " + symbol;
    }

    public static void main(String[] args) {
        double x = 10.0;
        double y = 5.0;

        for (EnumAdvancedDemo op : EnumAdvancedDemo.values()) {
            System.out.printf("%f %s %f = %f%n", x, op.getSymbol(), y, op.apply(x, y));
        }
    }
}
