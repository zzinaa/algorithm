import java.io.*;
import java.util.*;


public class 줄기세포배양 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visit;
    static int[][] map;
    static Queue<Cell> q;
    static final short D = 0, ACT = 1, INACT = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            map = new int[N + K + 2][M + K + 2];
            visit = new boolean[N + K + 2][M + K + 2];

            int tmp;

            for(int j = K / 2 + 1; j < N + K / 2 + 1; j ++) {
                st = new StringTokenizer(br.readLine());
                for(int k = K / 2 + 1; k < M + K / 2 + 1; k ++) {
                    tmp = Integer.parseInt(st.nextToken());
                    if(tmp != 0) {//0이 아닌 실제 셀만 넣어줌
                        q.add(new Cell(tmp, j, k));
                        map[j][k] = tmp;
                        visit[j][k] = true;
                    }
                }
            }

            int ans = breed(K);

            System.out.println("#" + i + " " + ans);

        }
    }


    private static int breed(int time) {
        for(int k = 0; k < time; k ++) {
            int size = q.size();

            for(Cell c : q)
                if(c.status == ACT) check(c);

            for(int i = 0; i < size; i ++) {

                Cell cur = q.poll();

                if(cur.status == ACT) {
                    for(int j = 0; j < 4; j ++) {
                        int nr = cur.r + dr[j];
                        int nc = cur.c + dc[j];

                        if(visit[nr][nc]) continue;

                        q.offer(new Cell(map[nr][nc], nr, nc));
                        visit[nr][nc] = true;
                    }
                }

                cur.next();

                if(cur.status == D) continue;
                q.add(cur);
            }
        }

        return q.size();
    }

    private static void check(Cell c) {
        for(int i = 0; i < 4; i ++) {
            int nr = c.r + dr[i];
            int nc = c.c + dc[i];

            if(visit[nr][nc]) continue;

            if(map[nr][nc] < c.x) map[nr][nc] = c.x;
        }
    }

    static class Cell{
        int tmp, x, r, c, status;

        public Cell(int x, int r, int c) {
            this.tmp = x; //셀의 현재 상태
            this.x = x; //셀의 생명력 수치
            this.r = r;
            this.c = c;
            this.status = INACT;
        }

        public void next() {
            if(status == INACT) {
                if(--tmp == 0) status = ACT;
            }else if(status == ACT) {
                if(++tmp == x) status = D;
            }
        }
    }
}
