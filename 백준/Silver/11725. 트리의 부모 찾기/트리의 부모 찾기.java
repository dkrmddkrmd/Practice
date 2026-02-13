import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            arr[first].add(second);
            arr[second].add(first);
        }

        int[] parent = new int[N+1];
        parent[1] = 1;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(1);

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
        for(int i = 2; i <= N; i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }
}