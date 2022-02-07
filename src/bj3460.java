import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj3460 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i ++) {
            int N = Integer.parseInt(br.readLine());

            String Bin = Integer.toBinaryString(N);

            for(int j = Bin.length() - 1; j >= 0; j --) {
                if(Bin.charAt(j) == '1') System.out.print(Bin.length()-j-1 + " ");
            }
            System.out.println();
        }
    }
}
