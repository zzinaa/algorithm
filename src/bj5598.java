import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj5598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int size = word.length();
        char[] arr = new char[size];

        for(int i = 0; i < size; i++) {
            if(word.charAt(i)-3<'A')
                arr[i] = (char)(word.charAt(i)+23);
            else arr[i] = (char)(word.charAt(i)-3);
        }

        for(int i = 0; i < size; i++) System.out.print(arr[i]);
    }
}
