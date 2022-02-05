import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15649 {

        static int N, M;
        static int[] arr;
        static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        dfs(0);
    }

    private static void dfs(int dep) {

        if(dep == M) {
            for(int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[dep] = i + 1;
                dfs(dep + 1);
                visited[i] = false;
            }
        }
    }
}
