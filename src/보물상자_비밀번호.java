import java.io.*;
import java.util.*;

public class 보물상자_비밀번호 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());



        for(int i = 0; i < T; i ++) {
            LinkedList<String> nums = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            String[] tmp = br.readLine().split("");

            for(String s : tmp) {
                nums.add(s);
            }

            int idx = 0;

            for(int n = 0; n < N/4; n ++) {

                for(int m = 0; m < 4; m ++) {
                    StringBuffer sb = new StringBuffer();

                    for(int j = 0; j < N/4; j ++) {
                        sb.append(nums.get(idx ++));
                    }

//					System.out.println(sb.toString());

                    int num = Integer.parseInt(sb.toString(), 16);
                    if(!list.contains(num)) list.add(num);
                }

                nums.addFirst(nums.removeLast());
                idx = 0;

            }

            Collections.sort(list, Collections.reverseOrder());

//			for(int num : list) System.out.println(num);

//			System.out.println();

            System.out.println("#"+(i+1) + " " + list.get(K - 1));

        }


    }

}
