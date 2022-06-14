package GuessNumber;

import java.util.Scanner;

public class Guess_NumberAPPmain {
    public static void main(String[] args) {
        Guess_Number guess_number = new Guess_Number(30, 50, 5);
        Scanner in = new Scanner(System.in);

        while (!guess_number.get_gameEnd()) {

            System.out.println("请输入猜测的数字，范围在(" + guess_number.get_rangeStart() + ","
                    + guess_number.get_rangeEnd() + ")。输入-1代表结束游戏");
            System.out.println(guess_number.GuessInit());


            while (guess_number.get_leftToGuess()> 0) {
                System.out.println("剩余猜测次数" + guess_number.get_leftToGuess() + "。请输入本次猜测的数字：");
                int Number = in.nextInt();
                if (Number < 0) {
                    guess_number.set_gameEnd(true);
                    System.out.println("用户选择结束游戏。");
                    break;
                }
                System.out.println(guess_number.Guess(Number));
            }

            if (!guess_number.get_correctGuess()) {
                System.out.println("本次的目标数字是：" + guess_number.get_NumToGuess());
            }
            System.out.println("共进行了" + guess_number.get_totalGameCount() + "次游戏，其中猜中的次数为" + guess_number.get_correctGuessCount());

        }
    }
}
