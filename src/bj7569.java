import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tmt {
    int x;
    int y;
    int h;

    tmt(int h, int x, int y) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

public class bj7569 {

    static int[] dx = { -1, 1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dh = { 0, 0, 0, 0, -1, 1 };

    static int M, N, H;
    static int[][][] Map;
    static Queue<tmt> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        int max = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        Map = new int[H][N][M];

        String[] temp;

        for (int k = 0; k < H; k++){
            for (int i = 0; i < N; i++) {
                temp = br.readLine().split(" ");

                for (int j = 0; j < M; j++) {
                    Map[k][i][j] = Integer.parseInt(temp[j]);
                    if (Map[k][i][j] == 1) {
                        q.offer(new tmt(k, i, j));
                    }
                }
            }
        }

        BFS();

        for(int k = 0; k < H; k ++){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (Map[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(Map[k][i][j], max);
                }
            }
        }
        System.out.println(max - 1);
    }

    public static void BFS() {
        while(!q.isEmpty()) {
            tmt cur = q.poll();

            for(int i = 0; i < 6; i ++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                int nh = dh[i] + cur.h;

                if(nx < N && nx >= 0 && ny < M && ny >= 0 && nh < H && nh >= 0) {
                    if(Map[nh][nx][ny] == 0) {
                        Map[nh][nx][ny] = Map[cur.h][cur.x][cur.y] + 1;
                        q.offer(new tmt(nh, nx, ny));
                    }
                }
            }
        }
    }
}

