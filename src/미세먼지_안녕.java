import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지_안녕 {

    static int R, C, T;
    static int[][] map;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    static int second;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i = 0; i < R; i ++) {
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j < C; j ++) {
                map[i][j] = Integer.parseInt(tmp[j]);
                if(Integer.parseInt(tmp[j]) == -1) second = i;
            }
        }

        for(int k = 0; k < T; k ++) {
            spread();
            clean();
        }

        for(int i = 0; i < R; i ++) {
            for(int j = 0; j < C; j ++) {
                if(map[i][j] > 0) answer += map[i][j];
            }
        }

        System.out.println(answer);
    }

    private static void spread() {

        int[][] tmp = new int[R][C];

        for(int i = 0; i < R; i ++) {
            for(int j = 0; j < C; j ++) {
                if(map[i][j] > 0) {

                    int cnt = 0;
                    for(int k = 0; k < 4; k ++) {
                        int ni = i + di[k];
                        int nj = j + dj[k];

                        if(ni < 0 || nj < 0 || ni >= R || nj >= C || map[ni][nj] == -1) continue;
                        tmp[ni][nj] += map[i][j] / 5;
                        cnt ++;
                    }

                    tmp[i][j] += map[i][j] - (map[i][j] / 5) * cnt;
                }
            }
        }

        map = tmp;
    }

    private static void clean() {

        int top = second - 1;
        int down = second;

        for(int i = top - 1; i > 0; i --)
            map[i][0] = map[i - 1][0];
        for(int i = 0; i < C - 1; i ++)
            map[0][i] = map[0][i + 1];
        for(int i = 0; i < top; i ++)
            map[i][C - 1] = map[i + 1][C - 1];
        for(int i = C - 1; i > 1; i --)
            map[top][i] = map[top][i - 1];

        for(int i = down + 1; i < R - 1; i ++)
            map[i][0] = map[i + 1][0];
        for(int i = 0; i < C - 1; i ++)
            map[R - 1][i] = map[R - 1][i + 1];
        for(int i = R - 1; i > down; i --)
            map[i][C - 1] = map[i - 1][C - 1];
        for(int i = C - 1; i > 1; i --)
            map[down][i] = map[down][i - 1];

        map[top][0] = -1;
        map[down][0] = -1;
        map[top][1] = 0;
        map[down][1] = 0;

    }
}
