import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // dist[i][j] = true : i가 j를 이김 (단방향)
        boolean[][] dist = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            dist[A][B] = true; // [수정 1] 단방향으로만 설정 (A가 B를 이김)
        }

        // 플로이드-워셜 (승패의 추이성 전파)
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // [수정 2] i -> k -> j 일 때만 i -> j 성립
                    if (dist[i][k] && dist[k][j]) {
                        dist[i][j] = true;
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;

                // [수정 3] i가 j를 이겼거나(dist[i][j]), j가 i를 이겼거나(dist[j][i])
                // 둘 중 하나라도 알면 승패 관계가 확인된 것
                if (dist[i][j] || dist[j][i]) {
                    cnt++;
                }
            }
            // 나를 뺀 나머지(N-1)와 모두 승패를 알 수 있다면 순위 확정
            if (cnt == N - 1)
                ans++;
        }

        System.out.println(ans);
    }
}