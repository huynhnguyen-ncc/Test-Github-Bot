package Annotation;

@Deprecated // Đánh dấu lớp này là đã lỗi thời
class A {
    public void showTheDataWhichBelongsToThisClass() {
        System.out.println("In A show");
    }
}

class B extends A{
//  Cố gắng ghi đè phương thức của lớp cha A
    @Override
    public void showTheDataWhichBelongsToThisClass() {
        System.out.println("In B show");
    }
}
public class AnnotationDemo {
    public static void main(String[] args) {
        B obj = new B();
        obj.showTheDataWhichBelongsToThisClass();
    }
}
