import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[7];
        ArrayList<Integer> odd = new ArrayList<>();
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < 7; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] % 2 - 1 == 0) odd.add(arr[i]);
        }

        if(odd.size() == 0) System.out.println(-1);
        else {
            for (int o :
                    odd) {
                sum += o;
                min = Math.min(min, o);
            }
            System.out.println(sum);
            System.out.println(min);
        }


    }
}
