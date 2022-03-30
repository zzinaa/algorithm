import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj14889 {

    static int N;
    static int[][] map;
    static boolean[] visit;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N]; //가로 세로 0 ~ N-1
        visit = new boolean[N];

        for(int i = 0; i < N; i ++) {
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j < N; j ++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        dfs(0, 0);

        System.out.println(MIN);
    }

    public static void dfs(int at, int dep) {

        if(dep == N/2) {

            dif();
            return;
        }

        for(int i = at; i < N; i ++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(i + 1, dep + 1);
                visit[i] = false;
            }
        }
    }

    private static void dif() {

        int start = 0;
        int link = 0;

        for(int i = 0; i < N - 1; i ++) {
            for(int j = i + 1; j < N; j ++) {
                if(visit[i] && visit[j]) {
                    start += map[i][j] + map[j][i];
                }
                if(!visit[i] && !visit[j]) {
                    link += map[i][j] + map[j][i];
                }
            }
        }

        int diff = Math.abs(start - link);
        System.out.println(diff);

        if(diff == 0) {
            System.out.println(0);
            System.exit(0);
        }

        MIN = Math.min(MIN, diff);
    }
}
