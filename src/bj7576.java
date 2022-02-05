import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato {
    int x;
    int y;

    tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class bj7576 {

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int M, N;
    static int[][] Map;
    static Queue<tomato> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        int max = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Map = new int[N][M];

        String[] temp;

        for(int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.parseInt(temp[j]);
                if(Map[i][j] == 1) {
                    q.offer(new tomato(i, j));
                }
            }
        }

        BFS();

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < M; j ++) {
                if(Map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(Map[i][j], max);
            }
        }
        System.out.println(max - 1);
    }

    public static void BFS() {
        while(!q.isEmpty()) {
            tomato cur = q.poll();

            for(int i = 0; i < 4; i ++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if(nx < N && nx >= 0 && ny < M && ny >= 0) {
                    if(Map[nx][ny] == 0) {
                        Map[nx][ny] = Map[cur.x][cur.y] + 1;
                        q.offer(new tomato(nx, ny));
                    }
                }
            }
        }
    }
}
