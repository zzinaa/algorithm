
public class recommend_id {
    public static String solution(String new_id) {

        String answer;
        answer = new_id.toLowerCase();

        char[] step1_arr = answer.toCharArray();
        StringBuilder step2 = new StringBuilder();
        for(char c : step1_arr) {
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '_' || c == '.' || c == '-')
                step2.append(c);
        }

        answer = step2.toString();
        while(answer.contains("..")) answer = answer.replace("..", ".");

        if(answer.startsWith(".")) answer = answer.substring(1);
        if(answer.endsWith(".")) answer = answer.substring(0, answer.length() - 1);

        if(answer.length() == 0) answer = "a";

        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        if(answer.endsWith(".")) answer = answer.substring(0, answer.length() - 1);

        while(answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        String new_id = "z-+.^.";
        System.out.println(solution(new_id));
    }
}
