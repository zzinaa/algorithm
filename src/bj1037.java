import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int max = 0, min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N > 1) {
            for (int a :
                    arr) {
                max = Math.max(a, max);
                min = Math.min(a, min);
            }
            System.out.print(max * min);
        }
        else System.out.println((int)Math.pow(arr[0], 2));

    }
}
