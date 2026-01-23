import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        long treeLen = 0;
        int left = 0;
        int right = 0;
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            right = Integer.max(right, trees[i]);
        }


        while (left < right){
            int mid = (left + right) / 2;
            treeLen = 0;
            for(int i = 0; i < N; i++){
                treeLen += Integer.max(0, trees[i] - mid);
            }
            if(treeLen >= M){
                ans = mid;
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        System.out.println(ans);
    }
}