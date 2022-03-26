import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj13549 {

    public static class Num {
        int n, dep;

        public Num(int n, int dep) {
            this.n = n;
            this.dep = dep;
        }
    }

    static int N, K;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];

        if (N >= K) {
            System.out.println((N - K));
            return;
        }

        BFS();

        System.out.println(min);

    }

    private static void BFS() {
        Queue<Num> q = new LinkedList<>();

        Num start = new Num(N, 0);

        q.offer(start);

        while (!q.isEmpty()) {
            Num cur = q.poll();
            visit[cur.n] = true;

            if (cur.n == K) min = Math.min(cur.dep, min);

            int next = cur.n * 2;
            if(next < visit.length && !visit[next]) {
                q.offer(new Num(next, cur.dep));
            }

            next = cur.n + 1;
            if(next < visit.length && !visit[next]) {
                q.offer(new Num(next, cur.dep + 1));
            }

            next = cur.n - 1;
            if(next >= 0 && !visit[next]) {
                q.offer(new Num(next, cur.dep + 1));
            }

        }
    }


}
