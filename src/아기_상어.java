import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    int dist;

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class 아기_상어 {

    static int N;
    static int[][] map;
    static int[] dx = { -1, 0, 0, 1 };
    static int[] dy = { 0, -1, 1, 0 };
    static Node cur;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i ++) {
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j < N; j ++) {
                int num = Integer.parseInt(tmp[j]);
                if(num == 9) {
                    cur = new Node(i, j, 0);
                    num = 0;
                }
                map[i][j] = num;
            }
        }

        bfs();
    }

    private static void bfs() {

        int sSize = 2; //아기 상어 크기
        int cnt = 0; //상어가 잡아먹은 물고기 수
        int answer = 0; //물고기 잡아먹을 수 있는 시간

        while(true) {
            PriorityQueue<Node> q = new PriorityQueue<>(((o1, o2) ->
                    o1.dist != o2.dist ? Integer.compare(o1.dist, o2.dist) : (o1.x != o2.x ? Integer.compare(o1.x, o2.x) : Integer.compare(o1.y, o2.y)))
            );
            boolean[][] visit = new boolean[N][N];
            boolean check = false;

            q.offer(new Node(cur.x, cur.y, 0));
            visit[cur.x][cur.y] = true;

            while (!q.isEmpty()) {
                cur = q.poll();

                if (map[cur.x][cur.y] != 0 && map[cur.x][cur.y] < sSize) {
                    map[cur.x][cur.y] = 0;
                    cnt++;
                    answer += cur.dist;
                    check = true;
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny]) continue;
                    if (map[nx][ny] > sSize) continue;

                    q.add(new Node(nx, ny, cur.dist + 1));
                    visit[nx][ny] = true;
                }

//                for(Node n : q) {
//                    System.out.print("(" + n.x + "," + n.y + "," +n.dist + ") ");
//                }
//                System.out.println();
            }

            if(!check) break;
            if (cnt == sSize) {
                sSize++;
                cnt = 0;
            }
        }

        System.out.println(answer);
    }

}
