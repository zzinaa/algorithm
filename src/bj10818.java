import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10818 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = Integer.MAX_VALUE;
        int max = 0;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i ++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }

        System.out.println(min + " " + max);
    }
}
