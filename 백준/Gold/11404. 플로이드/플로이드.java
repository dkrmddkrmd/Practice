import java.util.*;
import java.io.*;

public class Main{
    static int INF = 999_999_999;

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] bus = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j)
                    continue;
                bus[i][j] = INF;
            }
        }

        StringTokenizer st;
        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            bus[a][b] = Math.min(bus[a][b], c);
        }

        // [✅] 수정된 루프 순서 (i, j, k 변수 의미 통일)
        for(int k = 1; k <= N; k++){ // k = 경유지
            for(int i = 1; i <= N; i++){ // i = 출발지
                for(int j = 1; j <= N; j++){ // j = 도착지
                    // i에서 j로 가는 비용 = min(기존 비용, i->k 비용 + k->j 비용)
                    bus[i][j] = Math.min(bus[i][j], bus[i][k] + bus[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(bus[i][j] == INF) {
                    sb.append(0).append(" "); // 👈 INF는 0으로 출력
                }
                else {
                    sb.append(bus[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}