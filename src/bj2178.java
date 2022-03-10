import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2178 {

    static int N, M, min;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M];
        min = 201;

        for(int i = 0; i < N; i ++) {
            String temp = br.readLine();
            map[i] = temp.toCharArray();
        }

        DFS(0, 0 , 0);

        System.out.println(min + 1);
    }

    public static void DFS(int x, int y, int cnt) {

        if(x == N - 1 && y == M - 1) {
            if(min > cnt) min = cnt;
            return;
        }

        visit[x][y] = true;

        for(int i = 0 ; i < 4; i ++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx < N && nx >= 0 && ny < M && ny >= 0) {
                if(!visit[nx][ny] && map[nx][ny] == '1') {
                    DFS(nx, ny, cnt + 1);
                    visit[nx][ny] = false;
                }
            }
        }
    }
}
