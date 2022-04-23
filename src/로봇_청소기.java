import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇_청소기 {

    static int N, M, dir;
    static int cnt = 0;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i ++) {
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j < M; j ++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        clean(y, x, dir);

        System.out.println(cnt);
    }

    private static void clean(int i, int j, int dir) {

        Node cleaner = new Node(i, j, dir);

        Queue<Node> q = new LinkedList<>();
        q.offer(cleaner);

        int ny, nx, newDir;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if(map[cur.y][cur.x] != -1) {
                map[cur.y][cur.x] = -1;
                cnt++;
//                System.out.println(cur.y + " " + cur.x + " " + cur.dir);
            }

            for (int k = 0; k < 4; k++) {
                //청소기 방향 기준 왼쪽으로 틀기
                newDir = (cur.dir + 3 - k) % 4;
                ny = cur.y + dy[newDir];
                nx = cur.x + dx[newDir];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 1 || map[ny][nx] == -1) continue;

//                System.out.println(ny + " " + nx);

                q.offer(new Node(ny, nx, newDir));
                break;
            }
            if(q.isEmpty()) {
                newDir = (cur.dir + 2) % 4;
                ny = cur.y + dy[newDir];
                nx = cur.x + dx[newDir];

                if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 1) continue;

                q.offer(new Node(ny, nx, cur.dir));
            }
        }



    }

    static class Node {
        int y, x, dir;
        public Node(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
}
