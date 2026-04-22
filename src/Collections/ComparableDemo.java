package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//  So sánh đối tượng Student này với đối tượng Student khác
    @Override
    public int compareTo(Student that) {
        if(this.age > that.age) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
//      Comparator là một interface, nên cần tạo anonymous class để sử dụng
//      Nếu phần tử sau nhỏ hơn phần tử trước thì sẽ trả về giá trị âm, nếu lớn hơn thì trả về giá trị dương, nếu bằng nhau thì trả về 0
//      Comparable hoạt động với các biến đối tượng, được dùng để chỉ định logic sắp xếp mặc định cho các đối tượng của lớp đó

/*  Tại sao một đối tượng được định nghĩa phải có Comparator, trong khi Integer thì không?
*   Vì lớp Integer đã implement interface Comparable, nên nó đã có logic sắp xếp mặc định
* */

//      Interface Comparable có phương thức compareTo
        Comparator<Integer> com = (i, j) -> i % 10 > j % 10 ? 1 : -1;
        List<Integer> nums = new ArrayList<>();
        nums.add(43);
        nums.add(31);
        nums.add(72);
        nums.add(29);

        Collections.sort(nums, com);
        System.out.println(nums);

        List<Student> studs = new ArrayList<>();
        studs.add(new Student(21, "Nguyen"));
        studs.add(new Student(12, "Ba"));
        studs.add(new Student(18, "Hoang"));
        studs.add(new Student(20, "Huynh"));
        Collections.sort(studs);
        for(Student s: studs) {
            System.out.println(s);
        }
    }
}
