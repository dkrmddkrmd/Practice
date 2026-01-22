import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main{
    static int N, M, V;
    static ArrayList<Integer>[] arr;
    static ArrayList<Integer> arrD, arrB;
    static boolean[] checkD, checkB;

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = new ArrayList<>();
        }

        arrD = new ArrayList<>();
        arrB = new ArrayList<>();
        checkB = new boolean[N+1];
        checkD = new boolean[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            arr[n1].add(n2);
            arr[n2].add(n1);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(arr[i]);
        }

        dfs(V);

        bfs(V);

        StringBuilder sb = new StringBuilder();

        for(int num : arrD){
            sb.append(num).append(" ");
        }

        sb.append("\n");

        for(int num : arrB){
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }

    static void dfs(int V){
        checkD[V] = true;
        arrD.add(V);

        for(int num : arr[V]){
            if(!checkD[num])
                dfs(num);
        }
    }

    static void bfs(int V){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(V);
        checkB[V] = true;

        while (!dq.isEmpty()){
            int now = dq.pollFirst();
            arrB.add(now);

            for(int num : arr[now]){
                if(!checkB[num]){
                    dq.offerLast(num);
                    checkB[num] = true;
                }
            }
        }
    }
}