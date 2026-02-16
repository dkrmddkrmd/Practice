import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        arr = new int[M];

        backTracking(0);

        System.out.println(sb);
    }

    static void backTracking(int depth){
        if(depth == M){
            for(int i = 0; i < depth; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }
}