public class 큰_수_만들기 {
    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();
        int size = number.length();

        int max;
        int idx = 0;
        for(int i = 0; i < size - k; i ++) {
            max = 0;
            for(int j = idx; j <= i + k; j ++) {
                if(max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
