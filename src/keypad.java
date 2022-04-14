import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class keypad {
    public static String solution(int[] numbers, String hand) {
        String answer = "";

        int curL, curR;
        Map<Integer, Point> keypad = new HashMap<>();

        int num = 1;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j ++) {
                keypad.put(num ++, new Point(i, j));
            }
        }

        keypad.put(num, new Point(3, 0));
        keypad.put(num + 1, new Point(3, 2));
        keypad.put(0, new Point(3, 1));

        curL = 10;
        curR = 11;

        for(int i = 0; i < numbers.length; i ++) {
            int n = numbers[i];
            if(n == 1 || n == 4 || n == 7) {
                curL = n;
                answer += "L";
            }
            else if(n == 3 || n == 6 || n == 9) {
                curR = n;
                answer += "R";
            }
            else {
                Point LP = keypad.get(curL);
                Point RP = keypad.get(curR);
                Point NP = keypad.get(n);

                int LD = Math.abs(LP.x - NP.x) + Math.abs(LP.y - NP.y);
                int RD = Math.abs(RP.x - NP.x) + Math.abs(RP.y - NP.y);

                if(LD > RD) {
                    curR = n;
                    answer += "R";
                }
                else if(LD < RD) {
                    curL = n;
                    answer += "L";
                }
                else {
                    if(hand.equals("right")) {
                        curR = n;
                        answer += "R";
                    }
                    else {
                        curL = n;
                        answer += "L";
                    }
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        System.out.println(solution(numbers, hand));
    }

}
