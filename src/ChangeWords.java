import java.util.Arrays;

public class ChangeWords {

    boolean[] visit;
    int answer = 51;

    public int solution(String begin, String target, String[] words) {

        int WordsSize = words.length;
        visit = new boolean[WordsSize];

        if(!Arrays.asList(words).contains(target)) answer = 0;
        else DFS(begin, target, words, 0);

        return answer;
    }

    private void DFS(String begin, String target, String[] word, int cnt) {

        if(begin.equals(target)) {
            if(answer > cnt) answer = cnt;
            return;
        }

        for(int i = 0; i < word.length; i ++) {
            int dif = 0;
            for(int j = 0; j < begin.length(); j ++) {
                if(!String.valueOf(word[i].charAt(j)).equals(String.valueOf(begin.charAt(j)))) {
                   dif ++;
                }
            }
            if(dif == 1 && !visit[i]) {
                visit[i] = true;
                DFS(word[i], target, word, cnt + 1);
                visit[i] = false;
            }
        }
    }
}
