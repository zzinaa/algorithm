import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1743_인접행렬 {

    static int N, M, K;
    static int cnt;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        int answer = 0;
        String[] tmp;

        //이중 포문 안돌리려고 노력함..
        for(int i = 0; i < K; i ++) {
            tmp = br.readLine().split(" ");
            map[Integer.parseInt(tmp[0]) - 1][Integer.parseInt(tmp[1]) - 1] = 1;
        }

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < M; j ++) {
                if(!visit[i][j] && map[i][j] == 1) {
                    cnt = 0;
                    DFS(i, j);
                    answer = Math.max(answer, cnt);
                }
            }
        }

        System.out.println(answer);

    }

    private static void DFS(int x, int y) {
        visit[x][y] = true;
        cnt ++;

        for(int i = 0; i < dx.length; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < N && nx >= 0 && ny < M && ny >= 0 && !visit[nx][ny] && map[nx][ny] == 1) {
                DFS(nx, ny);
            }
        }
    }
}
