import java.util.ArrayList;
import java.util.Collections;

public class TravelRoute {

    ArrayList<String> routes = new ArrayList<>();
    boolean[] visit;

    public String[] solution(String[][] tickets) {

        visit = new boolean[tickets.length];

        DFS(tickets, "ICN", "ICN", 0);

        Collections.sort(routes);

        String[] answer = routes.get(0).split(" ");

        return answer;
    }

    public void DFS(String[][] tickets, String start, String route, int cnt) {
        if(cnt == tickets.length) {
            routes.add(route);
            return;
        }

        for(int i = 0; i < tickets.length; i ++) {
            if(!visit[i] && tickets[i][0].equals(start)) {
                visit[i] = true;
                DFS(tickets, tickets[i][1], route + " " + tickets[i][1], cnt + 1);
                visit[i] = false;
            }
        }
    }
}
