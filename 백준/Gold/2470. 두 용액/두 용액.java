import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        int start = 0;
        int end = N -1;

        int first = 0, second = 0;
        int ans = Integer.MAX_VALUE;

        while (start < end){
            int sum = arr[start] + arr[end];

            if(Math.abs(ans) > Math.abs(sum)){
                ans = sum;
                first = arr[start];
                second = arr[end];
                if(sum > 0)
                    end--;
                else
                    start++;
            }
            else{
                if(sum > 0)
                    end--;
                else
                    start++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(first).append(" ").append(second);
        System.out.println(sb);
    }
}