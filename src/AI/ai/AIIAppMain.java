package AI.ai;

import java.util.Scanner;

public class AIIAppMain {
    public static void main(String[] args) {
        AI ai2 = new AI();
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.next();
            if ("exit".equals(input)) {
                System.out.println("再见！");
                break;
            }
            String answer = ai2.answer(input);
            System.out.println(answer);
        }
    }
}
