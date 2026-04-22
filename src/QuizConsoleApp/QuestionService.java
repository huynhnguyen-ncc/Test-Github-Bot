package QuizConsoleApp;

import java.util.Scanner;

public class QuestionService {
    Question[] questions = new Question[5]; // Mảng chứa các câu hỏi
//    Đây chỉ là một mảng tham chiếu chứ không phải là mảng chứa các đối tượng Question thực tế
    String selection[] = new String[5]; // Mảng chứa lựa chọn của người dùng, có thể dùng để lưu trữ câu trả lời của người dùng
    public QuestionService() {
        questions[0] = new Question(1, "size of int", "2", "6", "4", "8", "4"); // Khởi tạo đối tượng Question tại vị trí đầu tiên của mảng, giá trị câu hỏi là "size of int"
        questions[1] = new Question(2, "size of double", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, "size of char", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, "size of long", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, "size of boolean", "1", "2", "4", "8", "1");
    }
    public void playQuiz() {
        int i = 0;
        for(Question q: questions) {
//            System.out.println(q.getQuestion()); // Gặp lỗi NullPointerException nếu mảng chưa được khởi tạo
            System.out.println("Question no. : " + q.getId());
            System.out.println(q.getQuestion());
            System.out.println(q.getOpt1());
            System.out.println(q.getOpt2());
            System.out.println(q.getOpt3());
            System.out.println(q.getOpt4());
            Scanner sc = new Scanner(System.in); // System.in được dùng để nhận thông tin input từ user
//          Scanner là một lớp trong Java dùng để đọc dữ liệu từ các nguồn khác nhau như bàn phím, file, chuỗi, v.v.
            selection[i] = sc.nextLine(); // Nhận lựa chọn của người dùng từ bàn phím
            i++;
        }
//      Những gì nhận được là tham chiếu của câu hỏi đầu tiên trong mảng, nhưng mảng này chưa được khởi tạo với các đối tượng Question
//      Nếu như chỉ in q mà chưa khởi tạo phương thức toString() thì sẽ in ra địa chỉ của đối tượng Question trong bộ nhớ, không phải là nội dung của câu hỏi
        for(String s: selection) {
            System.out.println(s);
        }
    }
    public void printScore() {
        int score = 0;
        for(int i = 0; i < questions.length; i++) {
            Question que = questions[i]; // Lấy từng câu hỏi từ mảng
            String actualAnswer = que.getAnswer(); // Lấy câu trả lời đúng từ đối tượng Question
            String userAnswer = selection[i]; // Lấy câu trả lời của người dùng từ mảng selection
            if(actualAnswer.equals(userAnswer)) {
                score++;
            }
        }
        System.out.println("Your score is: " + score);
    }
}
