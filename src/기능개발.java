import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < progresses.length; i ++) {
            double rmd = (100 - progresses[i]) / (double) speeds[i];
            int day = (int) Math.ceil(rmd);

            if(!q.isEmpty() && q.peek() < day) {
                list.add(q.size());
                q.clear();
            }

            q.offer(day);
        }

        list.add(q.size());

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i ++)
            answer[i] = list.get(i);

        return answer;
    }
}
