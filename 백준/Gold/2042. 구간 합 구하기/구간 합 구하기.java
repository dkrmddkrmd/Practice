import java.util.*;
import java.io.*;

public class Main{
    static long[] arr, tree;

    static long Init(int node, int start, int end){
        if(start == end){
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = Init(node * 2, start, mid) + Init(node * 2 + 1, mid + 1, end);
    }

    static void update(int node, int start, int end, int index, long diff){
        if(index < start || index > end){
            return;
        }

        tree[node] += diff;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, index, diff);
        update(node * 2 + 1, mid + 1, end, index, diff);
    }

    static long query(int node, int start, int end, int left, int right){
        if(right < start || left > end)
            return 0;

        if(left <= start && end <= right){
            return tree[node];
        }

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) + query(node* 2 + 1, mid + 1, end, left, right);
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        tree = new long[N * 4];

        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Init(1, 0, N-1);

        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                int index = b - 1;
                long diff = c - arr[b - 1];
                arr[index] = c;

                update(1, 0, N-1, index, diff);
            }
            else if (a == 2){
                sb.append(query(1, 0, N-1, b - 1, (int) c - 1)).append("\n");
            }
        }

        System.out.println(sb);
    }
}