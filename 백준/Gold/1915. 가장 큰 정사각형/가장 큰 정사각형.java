import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            for(int j = 1; j <= M; j++){
                char c = str.charAt(j-1);
                arr[i][j] = c - '0';
            }
        }

        int maxVal = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if (arr[i][j] == 1) {
                    // 2. 주변(왼쪽, 위, 대각선)의 dp 값 중 최솟값 + 1
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    maxVal = Math.max(maxVal, dp[i][j]);
                }
                maxVal = Integer.max(maxVal, dp[i][j]);
            }
        }

        System.out.println(maxVal * maxVal);
    }
}