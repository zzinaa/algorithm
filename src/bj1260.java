import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1260 {

    static ArrayList<Integer>[] lists;
    static int N, M;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N은 정점 개수, M은 간선 개수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        lists = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i ++) {
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            lists[from].add(to);
            lists[to].add(from);
        }

        for(int i = 1; i <= N; i ++) {
            Collections.sort(lists[i]);
        }

        DFS(start);

        Arrays.fill(visit, false);
        System.out.println();

        BFS(start);

    }

    private static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for(int i = 0; i < lists[node].size(); i ++) {
                int cur = lists[node].get(i);
                if(!visit[cur]) {
                    q.offer(cur);
                    visit[cur] = true;
                }
            }
        }
    }

    private static void DFS(int v) {
        System.out.print(v + " ");
        visit[v] = true;

        for(int i = 0; i < lists[v].size(); i ++){
            int cur = lists[v].get(i);
            if(!visit[cur]) DFS(cur);
        }
    }
}
