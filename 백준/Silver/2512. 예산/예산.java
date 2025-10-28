import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int total = 0;
        int maxVal = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
            maxVal = Math.max(maxVal, arr[i]);
        }

        int M = Integer.parseInt(br.readLine());

        if(total <= M){
            System.out.println(maxVal);
            return;
        }

        int left = 0;
        int right = maxVal;

        int ans = 0;

        while (left <= right){
            int nowTotal = 0;

            int mid = (left + right) / 2;

            for(int i = 0; i < N; i++){
                if(mid >= arr[i]){
                    nowTotal += arr[i];
                }
                else{
                    nowTotal += mid;
                }
            }

            if(nowTotal <= M){
                ans = Math.max(ans, mid);
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}