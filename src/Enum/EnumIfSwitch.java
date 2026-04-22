package Enum;

public class EnumIfSwitch {
    public static void main(String[] args) {
        Status s = Status.Pending;

//      Enum trong Java extends từ lớp java.lang.Enum, do đó có thể sử dụng các phương thức của lớp này
        System.out.println(s.getClass().getSuperclass());
        if(s == Status.Running) {
            System.out.println("All Good");
        }
        else if(s == Status.Failed) {
            System.out.println("Try Again");
        }
        else if(s == Status.Pending) {
            System.out.println("Please Wait");
        }
        else {
            System.out.println("Done");
        }

        switch (s) {
            case Running:
                System.out.println("All Good");
                break;
            case Failed:
                System.out.println("Try Again");
                break;
            case Pending:
                System.out.println("Please Wait");
                break;
            case Success:
                System.out.println("Done");
                break;
        }
    }
}
