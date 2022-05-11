import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {
    public String[] solution(String[] record) {

        ArrayList<String> records = new ArrayList<>();
        //id, name
        HashMap<String, String> user = new HashMap<>();

        for(String r : record) {
            String[] tmp = r.split(" ");
            String id, name;

            if(tmp.length == 3) { //들어오기, 변경하기
                id = tmp[1]; name = tmp[2];
                user.put(id, name);
            }
        }

        for(String r : record) {
            StringBuilder sb = new StringBuilder();
            String[] tmp = r.split(" ");

            if(tmp[0].equals("Enter")) {
                sb.append(user.get(tmp[1])).append("님이 들어왔습니다.");
            }
            else if(tmp[0].equals("Leave")) {
                sb.append(user.get(tmp[1])).append("님이 나갔습니다.");
            } else continue;

            records.add(sb.toString());
        }

        String[] result = new String[records.size()];

        records.toArray(result);

        return result;
    }
}
