import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 1. 배낭보다 무거운 건 당연히 패스 (조건 축소)
            if (K < w) continue;

            // 2. K부터 내 무게(w)까지 남김없이 역순으로 갱신!
            for (int j = K; j >= w; j--){
                dp[j] = Integer.max(dp[j], dp[j-w] + v);
            }
        }

        System.out.println(dp[K]);
    }
}