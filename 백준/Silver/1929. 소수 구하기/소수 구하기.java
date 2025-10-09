import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // true: 소수 아님, false: 소수 (또는 아직 검사 안 함)
        // boolean 배열의 기본값은 false이므로, 소수가 아니면 true로 바꿀 것임
        boolean[] isNotPrime = new boolean[N + 1];
        
        // 0과 1은 소수가 아님
        isNotPrime[0] = isNotPrime[1] = true;

        // 에라토스테네스의 체 알고리즘
        // 2부터 N의 제곱근까지 반복
        for (int i = 2; i * i <= N; i++) {
            // i가 소수라면 (아직 지워지지 않았다면)
            if (!isNotPrime[i]) {
                // i의 배수들을 모두 지움 (소수가 아니라고 표시)
                for (int j = i * i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        
        // M부터 N까지의 숫자 중, 지워지지 않은(소수인) 숫자들을 출력
        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                sb.append(i).append('\n');
            }
        }
        
        System.out.println(sb);
    }
}