import java.util.*;

class 더_맵게 {
    public int solution(int[] scoville, int K) {

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int s : scoville) {
            pq.offer(s);
        }

        int fst, snd, newS;

        while(pq.peek() < K) {

            if(pq.size() == 1) return -1;

            answer ++;
            fst = pq.poll();
            snd = pq.poll();

            newS = fst + snd * 2;

            pq.offer(newS);
        }

        return answer;
    }
}