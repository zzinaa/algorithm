import java.util.*;

public class 메뉴_리뉴얼 {
//    class combi {
//        String menu;
//        int cnt;
//        public combi(String menu, int cnt) {
//            this.menu = menu;
//            this.cnt = cnt;
//        }
//    }

    public static void main(String[] args) {
        String[] ans = solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});

        for(String a : ans)
            System.out.print(a + ", ");
    }
    static Map<String, Integer> cntMap;
    static String[] arr;
    static int N;
    static public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        for(int num : course) {
            cntMap = new HashMap<>();
            arr = new String[num];
            N = num;
            for(String order : orders) {
                String[] orderArr = order.split("");
                Arrays.sort(orderArr);
                comb(0, 0, orderArr);
            }

            if(!cntMap.isEmpty()) {
                List<Integer> cntList = new ArrayList<>(cntMap.values());
                int max = Collections.max(cntList);

                if(max > 1)
                    for(String key : cntMap.keySet())
                        if(cntMap.get(key) == max)
                            answer.add(key);
            }
        }

        Collections.sort(answer);
        String[] ans = new String[answer.size()];
        for(int i = 0; i < answer.size(); i ++)
            ans[i] = answer.get(i);

        return ans;
    }

    static private void comb(int dep, int at, String[] order) {
        if(dep == N) {
            StringBuilder sb = new StringBuilder();
            for(String s : arr)
                sb.append(s);

            String menus = sb.toString();

//            System.out.println(menus);

            if(cntMap.containsKey(menus)) cntMap.put(menus, cntMap.get(menus) + 1);
            else cntMap.put(menus, 1);

            return;
        }

        for(int i = at; i < order.length; i ++) {
            arr[dep] = order[i];
            comb(dep + 1, i + 1, order);
        }
    }
}
