public class MakePrimeNum {

    public int solution(int[] nums) {

        int N = nums.length;

        int cnt = 0;

        for(int i = 0; i < N-2; i++) {
            for(int j = i + 1; j < N-1; j++) {
                for(int k = j + 1; k < N; k ++) {
                    int comb = nums[i] + nums[j] + nums[k];
                    if(isPrime(comb)) cnt ++;
                }
            }
        }

        return cnt;
    }

    public boolean isPrime(int num) {
        for(int i = 2; i*i <= num; i ++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
