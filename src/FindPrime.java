import java.util.ArrayList;
import java.util.List;

class FindPrime {

    int cnt = 0;
    List<String> all = new ArrayList<>();

    public int solution(String numbers) {
        int size = numbers.length();

        List<Integer> arr = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        //numbers -> arr list에 넣기
        for(int i = 0; i < size; i ++) {
            arr.add(numbers.charAt(i)-'0');
        }

        //arr list 넘겨서 뽑는 개수 별 조합 구하기 + 구하면 소수 체크
        for(int i = 1; i <= size; i ++) {
            pmt(arr, result, size, i);
        }

        return cnt;
    }

    //조합 구하기
    public void pmt(List<Integer> arr, List<Integer> result, int n, int r) {
        if(r == 0 && result.get(0) != 0) {

            //재귀 끝나고 조합 만들어 소수 체크
            String str = "";
            for(int rs : result) {
                str += rs;
            }

            if(!all.contains(str)) {

                all.add(str);

                int num = Integer.parseInt(str);
                if(isPrime(num)) cnt ++;
            }

        }

        for(int i = 0; i < n; i++) {
            result.add(arr.remove(i));
            pmt(arr, result, n-1, r-1);
            arr.add(i, result.remove(result.size() - 1));
        }
    }

    public boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i = 2; i*i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
