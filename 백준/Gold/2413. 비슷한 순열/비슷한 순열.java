import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int[] ans = new int[N + 1];

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(ans[num] != 0){
                sb.append(ans[num]).append(" ");
            }
            else{
                if(num == 1){
                    ans[num] = num;
                    sb.append(ans[num]).append(" ");
                    continue;
                }

                if(ans[num-1] == 0){
                    ans[num-1] = num;
                    ans[num] = num-1;
                    sb.append(ans[num]).append(" ");
                }
                else{
                    ans[num] = num;
                    sb.append(ans[num]).append(" ");
                }
            }
        }

        System.out.println(sb);
    }
}