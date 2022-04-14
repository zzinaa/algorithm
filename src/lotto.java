public class lotto {

    public int[] solution(int[] lottos, int[] win_nums) {

        int correct = 0;
        int zero = 0;

        for(int i = 0; i < 6; i ++) {
            if(lottos[i] == 0) {
                zero ++;
                continue;
            }
            for(int j = 0; j < 6; j ++) {
                if(lottos[i] == win_nums[j]) correct ++;
            }
        }

        int best, worst;

        best = 7 - (correct + zero);
        worst = 7 - correct;

        if(best == 7) best = 6;
        if(worst == 7) worst = 6;

        int[] answer = new int[2];

        answer[0] = best;
        answer[1] = worst;

        return answer;
    }
}
