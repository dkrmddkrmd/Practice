import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0;
        int end = N-1;
        int ans = 0;
        while (start < end){
            int sum = arr[start] + arr[end];

            if(sum == x){
                ans++;
                start++;
                end--;
            }
            else if(sum > x){
                end--;
            }
            else{
                start++;
            }
        }

        System.out.println(ans);
    }
}