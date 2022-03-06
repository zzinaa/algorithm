import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj2606 {
    static int N, M, cnt;
    static ArrayList<Integer>[] lists;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cnt = 0;

        lists = new ArrayList[N + 1];
        visit = new boolean[N + 1];


        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            lists[from].add(to);
            lists[to].add(from);
        }

        DFS(1);

        System.out.println(cnt - 1);
    }

    private static void DFS(int v) {
        visit[v] = true;
        cnt ++;

        for(int i = 0; i < lists[v].size(); i ++) {
            int cur = lists[v].get(i);
            if(!visit[cur]) DFS(cur);
        }
    }
}
