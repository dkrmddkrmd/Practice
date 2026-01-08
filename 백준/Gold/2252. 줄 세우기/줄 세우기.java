import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[N+1];
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            inDegree[b]++;
        }

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0)
                dq.offerLast(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()){
            int now = dq.pollFirst();
            sb.append(now).append(" ");

            for(int num : arr[now]){
                inDegree[num]--;
                if(inDegree[num] == 0)
                    dq.offerLast(num);
            }
        }

        System.out.println(sb);
    }
}