package GuessNumber;

public class Guess_Number {
    private int rangeStart;
    private int rangeEnd;
    private int guessTotal;
    private int totalGameCount=0;
    private int correctGuessCount = 0;
    private int leftToGuess;
    //private boolean gameEnd= false;
    private boolean gameEnd = false;
    private boolean currentGameCounted;
    private boolean correctGuess;
    private int NumToGuess;

    public Guess_Number(int rangeStart, int rangeEnd, int guessTotal) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.guessTotal = guessTotal;
    }

    public boolean get_gameEnd(){return gameEnd;}
    public void set_gameEnd(boolean gameEnd){this.gameEnd=gameEnd;}
    public int get_rangeStart(){return rangeStart;}
    public int get_rangeEnd(){return rangeEnd;}
    public int get_totalGameCount(){return totalGameCount;}
    public int get_correctGuessCount(){return correctGuessCount;}
    public int get_leftToGuess(){return leftToGuess;}
    public boolean get_correctGuess(){return correctGuess;}
    public int get_NumToGuess(){return NumToGuess;}

    public String GuessInit(){
        String ret = null;
        int mod = rangeEnd - rangeStart;

        if (rangeStart < 0 || rangeEnd < 0) {
            return ret = WrongInNum();
        }

        if (mod <=1) {
            return ret = IllegalNumRange();
        }

        NumToGuess = GenRanNum();
        return "随机数已生成，可以开始游戏！";

    }

    public String Guess(int Number) {
        String ret = null;
        return ret=StartGuessNum(Number, NumToGuess);
    }

    //生成随机数
    private int GenRanNum() {
        int mod = rangeEnd - rangeStart;
        int bigRandom = (int) (Math.random() * rangeEnd * 100);
        int NumToGuess = (bigRandom % mod) + rangeStart;
        leftToGuess = guessTotal;
        currentGameCounted = false;
        correctGuess = false;
        if (NumToGuess <= rangeStart) {
            NumToGuess = rangeStart + 1;
        } else if (NumToGuess > rangeEnd) {
            NumToGuess = rangeEnd - 1;
        }
        return NumToGuess;
    }

    //开始猜数字
    private String StartGuessNum(int Number, int NumToGuess) {

        if (!currentGameCounted) {
            totalGameCount++;
            currentGameCounted = true;
        }
        leftToGuess--;
        if (Number > NumToGuess) {
            return "输入的数字比目标数字大";
        } else if (Number < NumToGuess) {
            return "输入的数字比目标数字小";
        } else {
            correctGuessCount++;
            correctGuess = true;
            return "输入的数字正确!";
        }
    }

    //输入数字错误
    private String WrongInNum() {
        return "开始和结束必须是整数或者零";
    }

    private String IllegalNumRange() {
        return "非法的数字范围：(" + rangeStart + "," + rangeEnd + ")";
    }
}
