import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MVP_다이아몬드 {
    public static void main(String[] args) throws IOException {
        int[] level = new int[5];
        String[] levelS = {"B", "S", "G", "P", "D"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < 5; i ++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        String[] mvps = br.readLine().split("");

        int sum = 0;
        int last = 0;

        for(int i = 0; i < mvps.length; i ++) {
            String cur = mvps[i];
            int idx = Arrays.asList(levelS).indexOf(cur);

            if(idx == 4) {
                last = level[4];
            } else last = level[idx + 1] - last - 1;

            sum += last;
        }

        System.out.println(sum);
    }
}
