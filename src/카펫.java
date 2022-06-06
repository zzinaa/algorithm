class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i = 1; i <= yellow / 2; i ++) {
            int sero, garo;
            if(yellow % i == 0) {
                sero = i;
                garo = yellow / sero;

                int sum = sero * 2 + 4 + garo * 2;

                if(sum == brown) {
                    answer[0] = garo + 2;
                    answer[1] = sero + 2;
                    break;
                }
            }

        }

        if(yellow == 1) {
            answer[0] = 3;
            answer[1] = 3;
        }

        return answer;
    }
}