package String;

public class StringBufferStringBuilder {
    public static void main(String[] args) {
//      Có thể thay đổi được nội dung của StringBuffer
//      StringBuffer cung cấp "buffer size"
        StringBuffer sb = new StringBuffer("Huynh");
        System.out.println(sb.capacity());
        System.out.println(sb.length()); // In ra độ dài của chuỗi

/*
* Giá trị mặc định của StringBuffer là 16, tức là nó có thể chứa 16 ký tự trước khi cần mở rộng
* Đối với chuỗi "Huynh", có 5 ký tự, nên sức chứa của StringBuffer là 16 + 5 = 21 vì lưu chuỗi và 16 ký tự trống
* Lý do là mỗi lần thay đổi dữ liệu, nó chiếm một vị trí bộ nhớ liên tục bên trong bộ nhớ heap,
* */

        sb.append(" Nguyen");
        System.out.println(sb);

        sb.insert(0, "Java ");
        System.out.println(sb);

/*
* StringBuffer an toàn với luồng còn StringBuilder thì không */
    }
}
