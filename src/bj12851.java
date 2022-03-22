import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj12851 {

    static int N, K;
    static boolean[] check;
    static int cnt = 0;
    static int iter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new boolean[100001];

        if (N >= K) {
            System.out.println((N - K) + "\n1");
            return;
        }

        BFS();

        System.out.println(iter);
        System.out.println(cnt);


    }

    private static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        int num;

        q.offer(N);

        while (!q.isEmpty()) {
            if(cnt != 0) return;
            int size = q.size();

            for(int i = 0; i < size; i ++) {
                num = q.poll();

                check[num] = true;
                int next;

                next = num + 1;
                if(next == K) cnt ++;
                else if(num + 1 < check.length && !check[num + 1]) q.offer(next);

                next = num - 1;
                if(next == K) cnt ++;
                else if(num - 1 >= 0 && !check[num - 1]) q.offer(next);

                next = num * 2;
                if(next == K) cnt ++;
                else if(num *2 < check.length && !check[num * 2]) q.offer(next);
            }

            iter ++;

        }
    }
}
