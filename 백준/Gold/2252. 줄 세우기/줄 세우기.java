import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] indegree = new int[N+1];
        ArrayList<Integer>[] arr = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A].add(B);
            indegree[B]++;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0)
                dq.offerLast(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()){
            int now = dq.pollFirst();
            sb.append(now).append(" ");
            for(int num : arr[now]){
                indegree[num]--;
                if(indegree[num] == 0){
                    dq.offerLast(num);
                }
            }
        }

        System.out.println(sb);
    }
}