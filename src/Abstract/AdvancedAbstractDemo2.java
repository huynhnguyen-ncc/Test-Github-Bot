package Abstract;

/**
 * Ví dụ nâng cao về lớp trừu tượng (Abstract Class).
 * - Sử dụng Generic để tăng tính linh hoạt.
 * - Áp dụng Template Method Pattern để định nghĩa khung thuật toán.
 * - Sử dụng từ khóa 'final' cho phương thức mẫu để ngăn chặn ghi đè.
 */
public abstract class AdvancedAbstractDemo2<T> extends Car {
    private final T model;

    protected AdvancedAbstractDemo2(T model) {
        this.model = model;
    }

    // Phương thức final: lớp con không thể thay đổi
    public final T getModel() {
        return model;
    }

    // Phương thức trừu tượng: buộc lớp con phải triển khai
    public abstract void startEngine();

    @Override
    public abstract void drive();

    // Template Method: định nghĩa thứ tự các bước
    public final void travel() {
        System.out.println("Bắt đầu chuyến hành trình với: " + model);
        startEngine();
        drive();
        playMusic(); // Phương thức cụ thể từ lớp cha Car
    }
}
