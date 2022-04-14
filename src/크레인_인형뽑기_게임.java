import java.util.Stack;

public class 크레인_인형뽑기_게임 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> bucket = new Stack<>();
        for(int m : moves) {
            for(int i = 0; i < board.length; i ++) {
                int cur = board[i][m - 1];
                if(cur != 0) {
                    if(!bucket.empty() && bucket.peek() == cur) {
                        answer += 2;
                        bucket.pop();
                    }
                    else bucket.push(cur);
                    board[i][m - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,1},{0,1,1,0,1},{1,1,1,1,1},{1,1,1,1,1}};
        int[] moves = {1,2,3,4};
        System.out.println(solution(board, moves));
    }
}
