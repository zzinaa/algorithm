import java.util.ArrayList;
import java.util.Collections;


public class 실패율 {
    public static void main(String[] args) {
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] ans;
        ans = solution(5, stages);

        for(int a : ans) System.out.print(a + " ");
    }
    static public int[] solution(int N, int[] stages) {
        //N은 총 스테이지 수, stages 는 사용자가 멈춰있는 스테이지의 번호를 담은 배열
        //실패율 = 스테이지에 도달했으나 깨지 못한 사람의 수 / 스테이지에 도달한 사람의 수(깬 사람 포함)

        int[] answer = new int[N];

        ArrayList<Rate> list = new ArrayList<>();

        for(int i = 1; i <= N; i ++) {
            double nonClear = 0, reach = 0;
            for(int s : stages) {
                if(s == i) nonClear ++;
                if(s > i) reach ++;
            }
            reach += nonClear;

            System.out.println(nonClear + " " + reach);

            if(reach == 0) {
                list.add(new Rate(i, 0));
                continue;
            }

            list.add(new Rate(i, nonClear/reach));
        }

        //내림차순
        Collections.sort(list, ((o1, o2) -> Double.compare(o2.fail, o1.fail)));

        int i = 0;
        for(Rate r : list) {
            answer[i ++] = r.stage;
        }

        return answer;
    }
}

class Rate {
    int stage;
    double fail;

    public Rate(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }
}
