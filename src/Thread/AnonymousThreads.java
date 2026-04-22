package Thread;

class Counter {
    int count;
    public synchronized void increment() {
        count++;
    }
//  Mỗi khi có thread nào gọi phương thức increment(), giá trị của count sẽ tăng lên 1
}

public class AnonymousThreads {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Runnable obj1 = () -> {
            for(int i = 1; i <= 1000; i++) {
                c.increment();
            }
        };
        Runnable obj2 = () -> {
            for(int i = 1; i <= 1000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
/*
* Khi bắt đầu thread
* t1 và t2 chạy trên hai luồng khác nhau, mục đích cho biến count tăng lên 2000
* Tuy nhiên, nhánh main() không làm gì cả
* t1 và t2 sẽ hoàn thành việc của chúng và kết thúc, sau đó main sẽ in ra giá trị của c.count
* */

/*
* Hai thread cùng gọi phương thức increment(), tức là lấy biến đếm count
* Phương thức increment() thực hiện hai bước:
* - Đầu tiên, nó lấy giá trị hiện tại của count
* - Sau đó, nó tăng giá trị của count lên 1
* Giả sử t1 lấy giá trị của count là 0, nó tăng giá trị count lên 1
* Sau đó t2 lấy giá trị của count là 1, nó cũng tăng giá trị count lên 2
* Sau đó t1 lại lấy giá trị của count là 2, nó tăng giá trị count lên 3
* Giả sử cả hai thread đều lấy giá trị của count là 3, cả hai đều tăng giá trị của count lên 4
* Hai thread này cùng gọi phương thức increment() nhưng phương thức này chỉ xảy ra một lần
* */

        t1.join(); // Phương thức join() sẽ chờ cho đến khi luồng t1 kết thúc
        t2.join();

        System.out.println(c.count);
//      Mỗi lần chạy lệnh code này, giá trị của c.count có thể khác nhau
    }
}
