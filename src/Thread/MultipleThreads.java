package Thread;

class A implements Runnable { // Vì Runnable là một interface, nên cần implement phương thức run()
    public void run() {
        for(int i = 1; i <= 1000; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(10); // Giả sử scheduler cho phép chỉ in một lần "Hi" trong 10 mili giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//          Khi in một lần "Hi", luồng sẽ tạm dừng trong 10 mili giây
//          Trong thời gian này, luồng sẽ không thực hiện bất kỳ công việc nào khác
        }
    }
}
class B implements Runnable {
    public void run() {
        for(int i = 1; i <= 1000; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(10); // Giả sử scheduler cho phép chỉ in một lần "Hello" trong 10 mili giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//          Khi in một lần "Hello", luồng sẽ tạm dừng trong 10 mili giây
//          Trong thời gian này, luồng sẽ không thực hiện bất kỳ công việc nào khác
/*
*  Trong trường hợp xuất hiện hai lần "Hello" liên tiếp
*  Sau khi thực hiện "Hello", hai luồng sẽ quay trở lại scheduler cùng một lúc
*  Scheduler sẽ quyết định luồng nào sẽ được thực thi tiếp theo
*  Scheduler đã trao cơ hội để luồng thực hiện "Hello" được thực hiện trước
*  Đó là lý do vì sao khi chơi game, đôi khi nhân vật của bạn không di chuyển theo trình tự hoặc không đồng bộ, vì các luồng không hoạt động bình thường
*  Scheduler có thể quyết định cho phép một luồng thực thi liên tục trong một khoảng thời gian dài, trong khi luồng khác không được thực thi
*  Điều này có thể dẫn đến tình trạng gọi là "starvation" (đói khát), khi một luồng không được thực thi trong một khoảng thời gian dài do scheduler ưu tiên cho các luồng khác
*  */
//
        }
    }
}
public class MultipleThreads {
    public static void main(String[] args) {
        Runnable obj1 = new A(); // 1. Trong bộ nhớ heap khởi tạo đối tượng obj1 của lớp A
        Runnable obj2 = new B(); // 2. Trong bộ nhớ heap khởi tạo đối tượng obj2 của lớp B
//        obj1.show(); // 3. Gọi phương thức show() của đối tượng obj1
//      4. Trình biên dịch sẽ tạo một luồng mới để thực thi phương thức show() của đối tượng obj1
//      5. Khi đó, phương thức main() sẽ chờ đợi cho đến khi luồng thực thi phương thức show() của obj1 kết thúc
//        obj2.show();
//      6. Sau khi luồng này kết thúc, chương trình sẽ tiếp tục thực thi phương thức show() của đối tượng obj2
//      Về cơ bản mọi thứ đều sẽ được thực hiện tuần tự, không có sự song song giữa các luồng

//      Phạm vi ưu tiên của luồng là từ 1 đến 10 (thấp nhất là 1, cao nhất là 10)
//      Mặc định, phạm vi ưu tiên của luồng là 5
//        obj2.setPriority(Thread.MAX_PRIORITY); // Đặt ưu tiên của luồng obj2 là cao nhất (10)
//        obj1.setPriority(Thread.MIN_PRIORITY);

/*
Giả sử phương thức show() của obj1 đang được thực thi
Đồng thời, thực hiện phương thức show() của obj2 ==> Thực hiện song song
Muốn thực hiện song song, ta cần sử dụng luồng (Thread) trong Java
Không thể thực thi các đối tượng cùng một lúc nếu không sử dụng luồng
 */

        Thread t1 = new Thread(obj1); // Phương thức start() thuộc về lớp Thread, vì vậy cần tạo một đối tượng Thread
        Thread t2 = new Thread(obj2);
//      Có một phương thức contructor của lớp Thread với đầu vào là một đối tượng Runnable

        t1.start(); // Gọi phương thức start() của đối tượng obj1 và obj2 để bắt đầu luồng mới
        t2.start();
//      Phương thức start() thuộc về lớp Thread, nó sẽ tạo một luồng mới và gọi phương thức run() của đối tượng đó
//      Trong mỗi luồng, cần có phương thức run()


/*
Giả sử trong một cuộc đua, nhiều người đang chờ để bắt đầu cuộc đua
Mọi người đều sẽ chờ đợi tín hiệu start() cuộc đua
Ngay khi có tín hiệu start(), mỗi người sẽ bắt đầu run()
*/

/*
* Trong trường hợp in được 10 lần "Hi" và 10 lần "Hello", khi đó chỉ cung cấp một ít thời gian vì máy tính chạy rất nhanh
* Ngay khi cho luồng A thời gian để thực thi, nó sẽ thực thi 10 lần "Hi" cùng một lúc
* */

/*
* Trong trường hợp thực thi 100 lần "Hi" và 100 lần "Hello", mọi thứ sẽ diễn ra song song
* Mỗi luồng sẽ thực thi song song với nhau. Hai phương thức run() sẽ được thực thi cùng một lúc
* */

/*
* Hệ điều hành cung cấp scheduler. Giả dụ nếu muốn bắt đầu một thread, cần phải gặp scheduler
* Hiện nay có CPU đa lõi, vì vậy có thể thực thi song song trên các lõi khác nhau
* Giả sử có 4 lõi CPU, khi đó có thể thực thi 4 luồng song song
* Nếu có số lượng lõi lên đến hàng nghìn, không thể thực thi tất cả các luồng cùng một lúc
* Vì vậy, có một khái niệm về scheduler, về cơ bản có trách nhiệm cho phép một luồng thực thi
* Giả sử có 8 luồng đang chờ thực thi và chỉ có 2 lõi CPU
* Scheduler chỉ có thể chạy hai luồng cùng một lúc
* Nhiệm vụ của scheduler là cho phép luồng nào được thực thi trên hệ điều hành
* */

/*
* Để tạo một luồng, có hai lựa chọn:
* - Extends lớp Thread
* - Implements interface Runnable
* Vấn đề duy nhất là interface Runnable không có phương thức start()
* Trong trường hợp đó, cần tạo một đối tượng Thread và truyền đối tượng Runnable vào constructor của lớp Thread
* */

    }
}
