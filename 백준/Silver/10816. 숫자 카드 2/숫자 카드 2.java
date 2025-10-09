import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // [수정 1] N은 첫 줄에 단독으로 주어집니다.
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> myMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            // [수정 2] getOrDefault를 사용하면 코드가 훨씬 간결해집니다.
            myMap.put(now, myMap.getOrDefault(now, 0) + 1);
        }

        // [수정 3] M도 그 다음 줄에 단독으로 주어집니다.
        int M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());
            // [수정 4] getOrDefault를 사용하면 if-else가 필요 없습니다.
            stringBuilder.append(myMap.getOrDefault(now, 0)).append(" ");
        }

        System.out.println(stringBuilder);
    }
}