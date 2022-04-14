import java.util.*;

class 신고_결과_받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //피신고인, 신고인리스트 맵
        Map<String, List<String>> reportMap = new HashMap<>();

        for(String id : id_list) {
            reportMap.put(id, new ArrayList<>());
        }

        for(String s : report) {
            String[] tmp = s.split(" ");
            if(!reportMap.get(tmp[1]).contains(tmp[0]))
                reportMap.get(tmp[1]).add(tmp[0]);
        }

        for(String person : reportMap.keySet()) {
            if(reportMap.get(person).size() >= k) {
                for(String reportPerson : reportMap.get(person)) {
                    answer[Arrays.asList(id_list).indexOf(reportPerson)] ++;
                }
            }
        }

        return answer;
    }
}