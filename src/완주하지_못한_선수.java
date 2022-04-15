import java.util.ArrayList;
import java.util.Arrays;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {

        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < participant.length; i ++) {
            if(!participant[i].equals(completion[i])) answer = participant[i];
            break;
        }

        return answer;
    }
}
