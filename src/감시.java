import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 감시 {

    static int N, M, result, ccCnt;
    static int[][] map;
    static CCTV[] cctvs;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    static int[][][] ccDir = {
            {{0}},
            {{1}, {2}, {3}, {0}},
            {{1, 3}, {0, 2}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{1, 2, 3}, {2, 3, 0}, {0, 1, 2}, {3, 1, 0}},
            {{0, 1, 2, 3}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cctvs = new CCTV[8];

        int remain = N * M;

        for(int i = 0; i < N; i ++) {
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j < M; j ++) {
                map[i][j] = Integer.parseInt(tmp[j]);

                if(map[i][j] > 0 && map[i][j] < 6) {
                    cctvs[ccCnt++] = new CCTV(map[i][j], i, j);
                }
                else if(map[i][j] == 6) remain --;
            }
        }

        result = Integer.MAX_VALUE;

        process(0, remain - ccCnt, map);

        System.out.println(result);
    }

    private static void process(int index, int remain, int[][] map) {
        if(index == ccCnt) {
            result = Math.min(result, remain);
            return;
        }

        int[][] newMap = new int[N][M];
        copy(map, newMap);

        CCTV c = cctvs[index];

        for(int i = 0; i < ccDir[c.type].length; i ++) {
            int check = 0;
            for(int j = 0; j < ccDir[c.type][i].length; j++) {
                int d = ccDir[c.type][i][j];
                check += obsv(c.i, c.j, d, newMap);
            }

            process(index + 1, remain - check, newMap);

            copy(map, newMap);
        }
    }

    private static int obsv(int i, int j, int d, int[][] map) {
        int cnt = 0;

        while(true) {
            i += di[d];
            j += dj[d];

            if(i < 0 || j < 0 || i >= N || j >= M || map[i][j] == 6) return cnt;
            if((map[i][j] >= 1 && map[i][j] <= 5) || map[i][j] == -1) continue;
            map[i][j] = -1;
            cnt ++;
        }
    }


    private static void copy(int[][] map, int[][] newMap) {
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < M; j ++) {
                newMap[i][j] = map[i][j];
            }
        }
    }

    static class CCTV {
        int type, i, j;

        public CCTV(int type, int i, int j) {
            this.type = type;
            this.i = i;
            this.j = j;
        }
    }
}
