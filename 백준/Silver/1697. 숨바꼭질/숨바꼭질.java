import java.util.*;
import java.io.*;

public class Main{
    static int N, K;

    static int[] point;

    static void bfs(int start){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(start);

        while(!dq.isEmpty()){
            int now = dq.pollFirst();

            int back = now -1;
            int front = now + 1;
            int move = now * 2;
            if(back >= 0 && back <= 100000 && point[back] == 0){
                point[back] = point[now] + 1;
                dq.offerLast(back);
            }
            if(front >= 0 && front <= 100000 && point[front] == 0){
                point[front] = point[now] + 1;
                dq.offerLast(front);
            }
            if(move >= 0 && move <= 100000 && point[move] == 0){
                point[move] = point[now] + 1;
                dq.offerLast(move);
            }
        }
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        point = new int[1000001];

        point[N] = 1;

        bfs(N);

        System.out.println(point[K] - 1);
    }
}