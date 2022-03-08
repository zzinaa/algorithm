import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class bj11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int x;

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i ++) {
            x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if (q.isEmpty()) System.out.println(0);
                else System.out.println(q.poll());
            }
            else q.add(x);
        }
    }
}
