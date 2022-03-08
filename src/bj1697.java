import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1697 {

    static int N, K;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new int[100001];

        if (N == K) {
            System.out.println(0);
        } else BFS();

    }

    private static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        int num;

        q.offer(N);

        while (!q.isEmpty()) {
            num = q.poll();

            if (num == K) {
                System.out.println(check[num]);
                return;
            }

            if(num + 1 < check.length && check[num + 1] == 0) {
                q.offer(num + 1);
                check[num + 1] = check[num] + 1;
            }
            if(num - 1 >= 0 && check[num - 1] == 0) {
                q.offer(num - 1);
                check[num - 1] = check[num] + 1;
            }
            if(num * 2 < check.length && check[num * 2] == 0) {
                q.offer(num * 2);
                check[num * 2] = check[num] + 1;
            }

        }
    }


}
