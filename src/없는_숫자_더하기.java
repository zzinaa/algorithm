import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 없는_숫자_더하기 {
    public int solution(int[] numbers) {

        int sum = 45;

        for(int n : numbers) {
            sum -= n;
        }

        return sum;
    }
}
