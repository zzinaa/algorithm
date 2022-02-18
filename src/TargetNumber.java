public class TargetNumber {
    int answer;

    public int solution(int[] numbers, int target) {

        answer = 0;

        dfs(0, 0, numbers, target);

        return answer;
    }

    public void dfs(int idx, int sum, int[] nums, int target) {

        if(idx == nums.length){
            if(sum == target) answer ++;
            return;
        }

        sum += nums[idx];

        dfs(idx+1, sum, nums, target);

        sum -= nums[idx];

        sum += (-1)*nums[idx];

        dfs(idx+1, sum, nums, target);

    }
}
