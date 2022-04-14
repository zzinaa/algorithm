import java.util.HashMap;
import java.util.Map;

public class 숫자_문자열과_영단어 {
    public static int solution(String s) {

        String[] numString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < 10; i ++) {
            s = s.replace(numString[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }
}
