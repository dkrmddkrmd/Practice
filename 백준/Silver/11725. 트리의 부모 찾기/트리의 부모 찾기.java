import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        arr = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            arr[first].add(second);
            arr[second].add(first);
        }

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(1);

        while (!dq.isEmpty()){
            int now = dq.pollFirst();

            for(int num : arr[now]){
                if(parent[num] == 0){
                    parent[num] = now;
                    dq.offerLast(num);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++)
            sb.append(parent[i]).append("\n");
        System.out.println(sb);
    }
}