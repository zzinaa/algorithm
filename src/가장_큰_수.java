import java.util.Arrays;

public class 가장_큰_수 {

    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        int i = 0;
        for(int n : numbers) arr[i++] = String.valueOf(n);

        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        if(arr[0].equals("0")) return "0";

        return String.join("", arr);
    }
}
