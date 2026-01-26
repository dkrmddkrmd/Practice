import java.util.*;
import java.io.*;

public class Main {
    static int num = 1_000_001;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[num];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;

        for(int i = 1; i < num; i++){
            if(i+1 < num && dp[i+1] > dp[i] + 1)
                dp[i+1] = dp[i] + 1;

            if(i * 2 < num && dp[i*2] > dp[i] + 1)
                dp[i*2] = dp[i] + 1;

            if(i * 3 < num && dp[i*3] > dp[i] + 1)
                dp[i*3] = dp[i] + 1;
        }

        System.out.println(dp[N]);
    }
}