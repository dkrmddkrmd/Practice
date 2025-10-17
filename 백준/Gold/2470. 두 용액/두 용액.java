import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = N-1;
        long A = -1, B = -1; // 정답
        long diff = Integer.MAX_VALUE;

        while (start < end){
            long nowDiff = arr[end] + arr[start];
            long absDiff = (long)Math.abs(nowDiff);
            if(absDiff < diff){
                diff = absDiff;
                A = arr[start];
                B = arr[end];
            }

            if(nowDiff < 0){
                start++;
            }
            else
                end--;
        }

        System.out.println(A + " " + B);
    }
}