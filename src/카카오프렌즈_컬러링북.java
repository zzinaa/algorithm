
public class 카카오프렌즈_컬러링북 {

    boolean[][] visited;
    int cnt = 1;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    visited[i][j] = true;
                    dfs(i, j, picture);
                    numberOfArea ++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                    cnt = 1;
                }
            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void dfs(int r, int c, int[][] picture) {
        for(int i = 0; i < 4; i ++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nc < 0 || nr >= picture.length || nc >= picture[0].length) continue;
            if(visited[nr][nc] || picture[nr][nc] != picture[r][c] || picture[nr][nc] == 0) continue;

            cnt ++;
            visited[nr][nc] = true;
            dfs(nr, nc, picture);
        }
    }


}
