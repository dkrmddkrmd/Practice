import java.util.*;
import java.io.*;

public class Main{
    static Deque<Integer> deque = new ArrayDeque<>();
    static StringBuilder stringBuilder = new StringBuilder();
    static boolean[] arr;

    static int N, M;

    static void backTracking(int n, int M){
        if(n == M){
            for(int d : deque){
                stringBuilder.append(d).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!arr[i]){
                deque.offerLast(i);
                arr[i] = true;
                backTracking(n+1, M);
                deque.pollLast();
                arr[i] = false;
            }
        }
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1];

        backTracking(0, M);

        System.out.println(stringBuilder);
    }
}