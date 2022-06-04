import java.util.*;

class Print {
    int pri;
    boolean chk;

    public Print(int pri, boolean chk) {
        this.pri = pri;
        this.chk = chk;
    }
}

public class 프린터 {
    public int solution(int[] priorities, int location) {

        Queue<Print> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < priorities.length; i ++) {
            boolean chk = false;
            if(i == location) chk = true;
            q.add(new Print(priorities[i], chk));
            pq.add(priorities[i]);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            Print cur = q.poll();

            if(cur.pri == pq.peek()) {
                cnt ++;
                if(cur.chk) break;
                pq.poll();
            } else q.add(cur);
        }

        return cnt;
    }
}
