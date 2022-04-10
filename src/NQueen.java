class Solution {

    int[] col;
    int answer;

    public int solution(int n) {
        answer = 0;

        for(int i = 0; i < n; i ++) {
            col = new int[n];
            col[0] = i;
            bcktrk(n, 1);
        }

        return answer;
    }

    private void bcktrk(int max, int row) {

        if(max == row) {
            answer ++;
            return;
        }

        for(int i = 0; i < max; i ++) {
            col[row] = i;
            if(isPossible(row))
                bcktrk(max, row + 1);
        }
    }

    private boolean isPossible(int row) {
        for(int i = 0; i < row; i ++) {
            if(col[i] == col[row]) return false; //윗 행 확인
            if(Math.abs(i - row) == Math.abs(col[i] - col[row])) return false; //대각선 확인(행의 증가량, 열의 증가량이 같으면 대각선)
        }
        return true;
    }
}