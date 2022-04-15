import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 완주하지_못한_선수_해시 {
    public String solution(String[] participant, String[] completion) {

        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        //참가자 value 값을 1로 초기화(동명이인이라면 2, 3, 4..가 되도록)
        for(String p : participant)
            map.put(p, map.getOrDefault(p, 0) + 1);

        //같은 해시 맵에서 완주자 value 값을 -1 해줌 (뛴 사람이 완주하면 value 는 0이 되로록)
        for(String c : completion)
            map.put(c, map.get(c) - 1);

        //0 이 아니면 완주한 사람이 아니므로 답이 된다.
        for(String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
