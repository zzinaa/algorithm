import java.util.*;

class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;

        Queue<Integer> q = new LinkedList<>();
        int sum = 0;

        for(int i = 0; i < truck_weights.length; i ++) {
            int truck = truck_weights[i];

            while(true) {
                if(q.isEmpty()) {
                    q.offer(truck);
                    time ++;
                    sum += truck;
                    break;
                } else if(q.size() == bridge_length) {
                    sum -= q.poll();
                } else {
                    if(truck <= (weight - sum)) {
                        q.offer(truck);
                        sum += truck;
                        time ++;
                        break;
                    } else {
                        q.offer(0);
                        time ++;
                    }
                }
            }
        }

        return time + bridge_length;
    }
}