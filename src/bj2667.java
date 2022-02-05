import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj2667 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int n, cnt;

    public static void main(String[] args) {

        String temp;
        ArrayList<Integer> result = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i<n; i++) {
            temp = sc.next();
            for(int j = 0; j<n; j++) {
                arr[i][j] = temp.charAt(j)-'0';
                visited[i][j] = false;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    cnt = 1;
                    result.add(DFS(i,j));
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int a : result) System.out.println(a);

    }

    public static int DFS(int i, int j){

        visited[i][j] = true;

        for(int k = 0; k < 4; k ++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if(!visited[nx][ny] && arr[nx][ny] == 1) {
                    DFS(nx, ny);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
