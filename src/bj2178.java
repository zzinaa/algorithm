import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178 {

    static int N, M;
//    static int min;
    static char[][] map;
    static int[][] visit; //visit 배열을 boolean 이 아닌 int 형으로 변경 -> 뎁스(최단거리) 확인
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new int[N][M];
//        min = 201;

        for(int i = 0; i < N; i ++) {
            String temp = br.readLine();
            map[i] = temp.toCharArray();
        }

//        DFS(0, 0 , 0);
//
//        System.out.println(min + 1);

        BFS();

        System.out.println(visit[N - 1][M - 1]);
    }

    public static void BFS() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0 ,0));
        visit[0][0] = 1;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            for(int i = 0; i < dx.length; i ++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if(nx < N && nx >= 0 && ny < M && ny >= 0 && visit[nx][ny] == 0 && map[nx][ny] == '1') {
                    q.offer(new Point(nx, ny));
                    visit[nx][ny] = visit[cur.x][cur.y] + 1;
                }
            }
        }
    }

//    public static void DFS(int x, int y, int cnt) {
//
//        if(x == N - 1 && y == M - 1) {
//            if(min > cnt) min = cnt;
//            return;
//        }
//
//        visit[x][y] = true;
//
//        for(int i = 0 ; i < dx.length; i ++) {
//            int nx = dx[i] + x;
//            int ny = dy[i] + y;
//
//            if(nx < N && nx >= 0 && ny < M && ny >= 0) {
//                if(!visit[nx][ny] && map[nx][ny] == '1') {
//                    DFS(nx, ny, cnt + 1);
//                    visit[nx][ny] = false;
//                }
//            }
//        }
//    }
}
