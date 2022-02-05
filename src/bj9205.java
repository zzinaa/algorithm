import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj9205 {

    static Point arr[];
    static Boolean visited[];
    static int N;

    public static void main(String[] args) throws IOException {
        int test;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        test = Integer.parseInt(br.readLine());

        for(int i = 0; i < test; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new Point[N+2];
            visited = new Boolean[N+2];

            StringTokenizer st;

            for(int j = 0; j < N+2; j ++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[j] = new Point(x, y);
                visited[j] = false;
            }

            BFS();

        }


    }

    public static void BFS() {
        boolean success = false;
        Queue<Point> q = new LinkedList<>();
        q.offer(arr[0]);
        visited[0] = true;
        while (!q.isEmpty()) {
            Point current = q.poll();

            if(current == arr[N+1]) {
                success = true;
                break;
            }

            for(int i = 1; i < N+2; i ++) {
                if(!visited[i] && (Math.abs(current.x - arr[i].x) + Math.abs(current.y - arr[i].y) <= 1000)) {
                    q.offer(arr[i]);
                    visited[i] = true;
                }
            }

        }
        if(success) System.out.println("happy");
        else System.out.println("sad");

    }
}
