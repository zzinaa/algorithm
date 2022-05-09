import java.util.ArrayList;

public class 폰켓몬 {

    public int solution(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (!list.contains(num)) list.add(num);
        }

        int ans = Math.min(list.size(), nums.length / 2);

        return ans;
    }
}
