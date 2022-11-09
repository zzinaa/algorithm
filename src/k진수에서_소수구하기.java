public class k진수에서_소수구하기 {
    public int solution(int n, int k) {
        int ans = 0;

        String bin = toBinary(n, k);
        String[] arr = bin.split("0");

        System.out.print(arr[0]);

        for (String s : arr) {
            if (s.isEmpty()) continue;
            if (isPrime(Long.parseLong(s)))
                ans++;
        }
        return ans;
    }

    private String toBinary(int n, int k) {
        StringBuilder sb = new StringBuilder();

        int rmd;

        while(n >= k) {
            rmd = n % k;
            sb.insert(0, rmd);
            n /= k;
        }

        sb.insert(0, n);

        return sb.toString();
    }

    private boolean isPrime(long n) {
        if(n == 1) return false;
        for(long i = 2; i * i <= n; i ++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
