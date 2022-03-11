import java.util.ArrayList;
import java.util.Collections;

public class NumOfKth {
    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i ++) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = commands[i][0] - 1; j < commands[i][1]; j ++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(commands[i][2] - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = solution(array, commands);
        for(int a : answer) System.out.print(a + " ");
    }
}
