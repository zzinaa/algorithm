import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기_확인하기 {

    //사방탐색
    int[] di = {0, 1, 0, -1};
    int[] dj = {1, 0, -1, 0};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int i = 0; i < 5; i ++) {
            String[] room = places[i];
            answer[i] = check(room);
        }
        return answer;
    }

    private int check(String[] room) {
        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 5; j ++) {
                if(room[i].charAt(j) == 'P') {
                    if(!bfs(room, i, j)) return 0;
                }
            }
        }
        return 1;
    }

    private boolean bfs(String[] room, int i, int j) {

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[5][5];

        queue.offer(new Point(i, j));
        visit[i][j] = true;

        while(!queue.isEmpty()) {

            Point cur = queue.poll();

            for(int k = 0; k < 4; k ++) {
                int ni = cur.x + di[k];
                int nj = cur.y + dj[k];
                int manhattan = Math.abs(i - ni) + Math.abs(j - nj);

                if(ni < 5 && ni >= 0 && nj < 5 && nj >= 0) {
                    if(!visit[ni][nj] && manhattan <= 2) {
                        if(room[ni].charAt(nj) == 'P')
                            return false;
                        else if(room[ni].charAt(nj) == 'O') {
                            queue.offer(new Point(ni, nj));
                            visit[ni][nj] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
