public class 삼진법_뒤집기 {
    public int solution(int n) {

        StringBuilder sb = new StringBuilder();

        while(n >= 3) {
            sb.append(n % 3);
            n /= 3;
        }

        sb.append(n);

        int idx = 0;
        int ans = 0;
        for(int i = sb.length() - 1; i >= 0; i --) {
            int num = sb.charAt(idx ++) - '0';
            ans += Math.pow(3, i) * num;
        }

        return ans;
    }
}
