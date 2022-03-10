import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1303 {

    static char[][] arr;
    static boolean[][] visit;
    static int N, M , cnt;
    static int[] dx = { -1, 1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[M][N];
        visit = new boolean[M][N];
        int white = 0;
        int blue = 0;

        for(int i = 0; i < M; i ++) {
            String temp = br.readLine();
            arr[i] = temp.toCharArray();
        }

        for(int i = 0; i < M; i ++) {
            for (int j = 0; j < N; j ++) {

                if(!visit[i][j]) {
                    cnt = 0;

                    if(arr[i][j] == 'W') {
                        DFS(i, j, 'W');
                        white += cnt * cnt;
                    } else {
                        DFS(i, j, 'B');
                        blue += cnt * cnt;
                    }
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    private static void DFS(int x, int y, char c) {

        visit[x][y] = true;
        cnt ++;

        for(int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < M && nx >= 0 && ny < N && ny >= 0 && arr[nx][ny] == c && !visit[nx][ny]) {
                DFS(nx, ny, c);
            }
        }
    }
}
