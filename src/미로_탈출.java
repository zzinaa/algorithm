import java.util.*;

class 미로_탈출 {

    static class Edge {
        int cost, node, state;
        public Edge(int cost, int node, int state) {
            this.cost = cost;
            this.node = node;
            this.state = state;
        }
    }

    static int[][] graph;
    static boolean[][] visit;
    static int MIN = Integer.MAX_VALUE;
    static PriorityQueue<Edge> q;


    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {

        graph = new int[n + 1][n + 1];
        visit = new boolean[n + 1][1 << 10];

        //우선순위 큐 : cost 기준
        q = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));


        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(i == j) graph[i][j] = 0;
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int[] data : roads) {
            int u = data[0];
            int v = data[1];
            int w = data[2];
            if(w < graph[u][v]) graph[u][v] = w;
        }


        return bfs(n, start, end, traps);
    }

    private static int bfs(int n, int start, int end, int[] traps) {

        q.add(new Edge(0, start, 0));

        while (!q.isEmpty()) {
            Edge cur = q.poll();

//            System.out.println("현재 노드 " + cur.node+ " " + Integer.toBinaryString(cur.state));

            if(cur.node == end) return cur.cost;

            if(visit[cur.node][cur.state]) continue;
            visit[cur.node][cur.state] = true;

//            System.out.println("실행");
            boolean currTrapped = false;

            //현재 방문한 노드 상태에서 트랩이 어떤 것이 켜져 있는지 확인할 수 있는 해시맵
            HashMap<Integer, Boolean> trapped = new HashMap<>();
            for(int i = 0; i < traps.length; i ++) {
                int bit = 1 << i;
                if((cur.state & bit) != 0) {//해당 트랩이 발동된 상태라면
                    if(traps[i] == cur.node) { //발동 됐는데, 다시 돌아온 경우(트랩 꺼져야 함)
                        cur.state &= ~bit;
                    } else { //발동 된 경우(트랩 켜진채 유지)
                        trapped.put(traps[i], true);
                    }
                } else { //발동 되지 않은 경우
                    if(traps[i] == cur.node) { //현재 방문한 노드가 트랩이므로 트랩 켜져야 함
//                        System.out.println("트랩 실행");
                        cur.state |= bit;
                        trapped.put(traps[i], true);
                        currTrapped = true;
                    }
                }
            }

            for(int v = 1; v < n + 1; v ++) {
                if(v == cur.node) continue; //모든 노드를 돌면서(현재 노드 제외하고)
                boolean nextTrapped = trapped.containsKey(v);
//                System.out.println(currTrapped + " " + nextTrapped);
//                System.out.println(graph[v][cur.node]);
                if(currTrapped == nextTrapped) { //현재 노드도, 다음 노드도 켜져있다면(원래대로)
                    if (graph[cur.node][v] != Integer.MAX_VALUE) {
//                        System.out.println(v);
                        q.add(new Edge(cur.cost + graph[cur.node][v], v, cur.state));
                    }
                }
                else {//현재 노드와 다음 노드의 트랩 켜짐이 다르다면(반대편으로)
                    if(graph[v][cur.node] != Integer.MAX_VALUE) {
//                        System.out.println(v);
                        q.add(new Edge(cur.cost + graph[v][cur.node], v, cur.state));
                    }
                }
            }

        }

        return Integer.MAX_VALUE;
    }


    public static void main(String[] args) {
        int[][] roads = {{1, 2, 2}, {3, 2, 3}};
        int[] traps = {2};
        int ans = solution(3, 1, 3, roads, traps);

        System.out.println(ans);
    }
}