import java.util.Arrays;

public class 행렬_테두리_회전하기 {
    public static void main(String[] args) {
        int[] ans = solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});

        for(int a : ans) System.out.println(a + " ");
    }
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        //[0][c], [r][0]은 쓰지 않는다
        int[][] map = new int[rows + 1][columns + 1];

        int n = 1;
        for(int i = 1; i <= rows; i ++) {
            for(int j = 1; j <= columns; j ++) {
                map[i][j] = n ++;
            }
        }

        for(int j = 0; j < queries.length; j ++) {
            int r1 = queries[j][0], c1 = queries[j][1], r2 = queries[j][2], c2 = queries[j][3];

            int tmp = map[r1][c1];
            int min = tmp;

            //왼쪽
            for(int i = r1; i < r2; i ++) {
                map[i][c1] = map[i + 1][c1];
                min = Math.min(min, map[i][c1]);
            }
            //아래
            for(int i = c1; i < c2; i ++) {
                map[r2][i] = map[r2][i + 1];
                min = Math.min(min, map[r2][i]);
            }
            //오른쪽
            for(int i = r2; i > r1; i --) {
                map[i][c2] = map[i - 1][c2];
                min = Math.min(min, map[i][c2]);
            }
            //위
            for(int i = c2; i > c1; i --) {
                map[r1][i] = map[r1][i - 1];
                min = Math.min(min, map[r1][i]);
            }

            map[r1][c1 + 1] = tmp;

            for(int r = 1; r <= rows; r ++){
                for(int c = 1; c <= columns; c ++) {
                    System.out.print(map[r][c] + " ");
                }
                System.out.println();
            }

            answer[j] = min;
        }

        return answer;
    }
}
