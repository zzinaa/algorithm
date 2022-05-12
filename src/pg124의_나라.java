public class pg124의_나라 {
    public String solution(int n) {
        String[] nums = {"4", "1", "2"};
        String answer = "";

        while(n > 0) {
            int rmd = n % 3;
            n /= 3;

            if(rmd == 0) n -= 1;

            answer = nums[rmd] + answer;
        }

        return answer;
    }
}
