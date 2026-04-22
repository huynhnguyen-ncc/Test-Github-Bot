package Interface;

abstract class Computer {
    public abstract void code();
}
// Có thể thay thế abstract class bằng interface, trong các lớp con sẽ phải implement phương thức code()

class Laptop extends Computer {
    public void code() {
        System.out.println("Coding, compile, run");
    }
}

class Desktop extends Computer {
    public void code() {
        System.out.println("Coding, compile, run : Faster");
    }
}

class Developer {
//  Developer phụ thuộc vào bất kỳ máy tính nào
    public void devApp(Computer lap) {
        lap.code();
    }
}

public class InterfaceNeed {
    public static void main(String[] args) {
        Computer lap = new Laptop();
        Computer desk = new Desktop();

        Developer dev = new Developer();
        dev.devApp(lap);
    }
}
