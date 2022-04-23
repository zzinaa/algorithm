import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class 톱니바퀴 {

    static LinkedList<Integer>[] gears;
    static int N;
    static int visit[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gears = new LinkedList[4];

        for(int i = 0; i < 4; i ++) {
            gears[i] = new LinkedList<>();
            String tmp[] = br.readLine().split("");
            for(int j = 0; j < 8; j ++) {
                gears[i].add(Integer.parseInt(tmp[j]));
            }
        }

        N = Integer.parseInt(br.readLine());

        int num, dir;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());

            visit = new int[4];

            check(num - 1, dir);
            roll(visit);
        }

        int sum = 0;

        for(int i = 0; i < 4; i ++) {
            if(gears[i].get(0) == 1)
                sum += Math.pow(2, i);
        }

        System.out.println(sum);
    }

    private static void check(int num, int dir) {

        visit[num] = dir;

        int prev = num - 1;
        int next = num + 1;

        if(prev >= 0 && visit[prev] == 0) {
            if(gears[num].get(6).intValue() != gears[prev].get(2).intValue())
                check(prev, dir * (-1));
        }

        if(next <= 3 && visit[next] == 0)
            if(gears[num].get(2).intValue() != gears[next].get(6).intValue())
                check(next, dir * (-1));
    }

    private static void roll(int[] visit) {

        for(int i = 0; i < 4; i ++) {
            if(visit[i] == 1)
                gears[i].addFirst(gears[i].removeLast());
            else if(visit[i] == -1)
                gears[i].addLast(gears[i].removeFirst());
        }

    }
}
