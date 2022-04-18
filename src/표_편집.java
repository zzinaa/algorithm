import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 표_편집 {

    Stack<Integer> stack = new Stack<>();
    int size;

    public String solution(int n, int k, String[] cmd) {

        size = n;

        for(String c : cmd) {
            char cur = c.charAt(0);
            if(cur == 'U' || cur == 'D') k = move(k, c);
            else if(cur == 'C') k = cancel(k);
            else k = rollBack(k);
        }

        return compare();
    }

    //이동하는 함수
    private int move(int k, String c) {

        StringTokenizer st = new StringTokenizer(c);
        String cmd = st.nextToken();

        int num = Integer.parseInt(st.nextToken());

        if (cmd.equals("U")) return k - num;
        else return k + num;
    }

    //삭제하는 함수
    private int cancel(int k) {

        stack.push(k);

        size --;
        if(size == k) k -= 1;

        return k;
    }

    //삭제한 걸 되돌리는 함수
    private int rollBack(int k) {

        int last = stack.pop();
        if(last <= k) k += 1;

        return k;
    }

    //비교하는 함수
    private String compare() {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append("O");
        }
        while(!stack.isEmpty()) {
            sb.insert(stack.pop(), "X");
        }

        return sb.toString();
    }
}
