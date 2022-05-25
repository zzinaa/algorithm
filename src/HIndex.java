import java.util.Arrays;
import java.util.Collections;

public class HIndex {
    public int solution(int[] citations) {

        Integer[] arr = new Integer[citations.length];
        for(int i = 0; i < citations.length; i ++) {
            arr[i] = citations[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int i;
        for(i = 0; i < arr.length; i ++) {
            if(i >= arr[i]) break;
        }

        return i;
    }
}
