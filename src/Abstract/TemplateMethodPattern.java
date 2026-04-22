package Abstract;

/**
 * KẾ THỨC NÂNG CAO: Template Method Design Pattern
 * Định nghĩa khung (skeleton) của một thuật toán trong một phương thức,
 * cho phép các lớp con định nghĩa lại các bước cụ thể của thuật toán đó
 * mà không thay đổi cấu trúc chung.
 */
abstract class Game {
    // Phương thức Template (final) để ngăn lớp con thay đổi cấu trúc
    public final void play() {
        initialize();
        startPlay();
        if (hasBonusLevel()) { // hook method
            playBonusLevel();
        }
        endPlay();
    }

    // Các bước cụ thể mà lớp con phải triển khai
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // Hook: có thể được lớp con ghi đè để cho bonus level
    boolean hasBonusLevel() { return false; }

    void playBonusLevel() { /* mặc định không làm gì */ }
}

class Football extends Game {
    @Override
    void initialize() { System.out.println("Football Game Initialized! Start playing."); }
    @Override
    void startPlay() { System.out.println("Football Game Started. Enjoy the game!"); }
    @Override
    void endPlay() { System.out.println("Football Game Finished!"); }
}

class Mario extends Game {
    @Override
    void initialize() { System.out.println("Mario Game Initialized! Loading levels..."); }
    @Override
    void startPlay() { System.out.println("Mario Game Started. Jump and run!"); }
    @Override
    void endPlay() { System.out.println("Mario Game Finished!"); }
    @Override
    boolean hasBonusLevel() { return true; }
    @Override
    void playBonusLevel() { System.out.println("Mario is in the secret Bonus Level! Collecting coins..."); }
}

public class TemplateMethodPattern {
    public static void main(String[] args) {
        System.out.println("--- Football ---");
        Game football = new Football();
        football.play();

        System.out.println("\n--- Mario ---");
        Game mario = new Mario();
        mario.play();
    }
}
