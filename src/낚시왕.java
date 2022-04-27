import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Shark{

    int r, c, s, d, z;

    public Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}

public class 낚시왕 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int R, C, M, res;
    static Shark[][] sea;
    static boolean suc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sea = new Shark[R][C];

        for(int i = 0; i < M; i ++) {
            String[] tmp = br.readLine().split(" ");
            int row = Integer.parseInt(tmp[0]) - 1;
            int col = Integer.parseInt(tmp[1]) - 1;
            int s = Integer.parseInt(tmp[2]);
            int d = Integer.parseInt(tmp[3]);
            int z = Integer.parseInt(tmp[4]);

            //상좌하우(0 1 2 3)으로 바꿔주기
            if(d == 1) d = 0;
            else if(d == 4) d = 1;

            sea[row][col] = new Shark(row, col, s, d, z);
        }

        res = 0;

        for(int i = 0; i < C; i++) {
            suc = false;
            fishing(0, i);
        }

        System.out.println(res);
    }

    private static void fishing(int row, int col) {

        if(row == R && !suc) {
            move();
            return;
        }

        if(sea[row][col] != null) {

            res += sea[row][col].z;
            sea[row][col] = null;

            suc = true;

            move();

            return;
        }

        fishing(row + 1, col);
    }

    private static void move() {
        Shark[][] tmp = new Shark[R][C];

        for(int i = 0; i < R; i ++) {
            for(int j = 0; j < C; j ++) {
                if(sea[i][j] != null) {
                    Shark cur = sea[i][j];
                    int speed = cur.s;
                    if(cur.d == 0 || cur.d == 2)
                        speed %= ((R - 1) * 2);
                    else
                        speed %= ((C - 1) * 2);

                    for(int k = 0; k < speed; k ++) {
                        int nr = cur.r + dr[cur.d];
                        int nc = cur.c + dc[cur.d];

                        if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
                            cur.r -= dr[cur.d];
                            cur.c -= dc[cur.d];
                            cur.d = (cur.d + 2) % 4;
                            continue;
                        }

                        cur.r = nr;
                        cur.c = nc;
                    }

                    if(tmp[cur.r][cur.c] == null)
                        tmp[cur.r][cur.c] = new Shark(cur.r, cur.c, cur.s, cur.d, cur.z);
                    else {
                        if(tmp[cur.r][cur.c].z < cur.z)
                            tmp[cur.r][cur.c] = new Shark(cur.r, cur.c, cur.s, cur.d, cur.z);
                    }
                }
            }
        }

        sea = tmp;
    }
}
