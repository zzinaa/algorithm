import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int[] result = new int[26];

        for(int i = 0; i < 26; i ++) {
            result[i] = -1;
        }

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if(result[ch-'a'] == -1) result[ch-'a'] = i;
        }

        for (int alpha :
                result) {
            System.out.print(alpha + " ");
        }

    }
}
