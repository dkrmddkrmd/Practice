import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<List<Integer>> node = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            node.add(new ArrayList<>());
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            node.get(p).add(c);
            node.get(c).add(p);
        }

        boolean[] visited = new boolean[N+1];
        int[] p = new int[N+1];

        visited[1] = true;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(1);
        while (!dq.isEmpty()){
            int now = dq.pollFirst();

            for(int c : node.get(now)){
                if(!visited[c]){
                    visited[c] = true;
                    p[c] = now;
                    dq.offerLast(c);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 2; i <= N; i++){
            stringBuilder.append(p[i]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}