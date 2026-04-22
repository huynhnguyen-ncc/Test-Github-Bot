package String;

public class StringDemo {
    public static void main(String[] args) {
        String name = new String("Huynh");
//      Có hai vùng nhớ là stack và heap
//      Vùng nhớ stack chứa tên biến và địa chỉ trỏ đến đối tượng trong vùng nhớ heap, còn vùng nhớ heap chứa giá trị "Huynh"

        System.out.println("Hello" + name);
//      String không hoạt động với bất kỳ toán tử trừ, nhân, chia, ngoại trừ toán tử cộng

        System.out.println(name.charAt(1));
        System.out.println(name.concat(" Nguyen")); // Nối chuỗi
    }
}
