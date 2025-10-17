import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // [수정] 입력 로직을 문제에 맞게 수정
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Integer>> cities = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            cities.add(new ArrayList<>());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    // i와 j가 연결되어 있음 (직접 연결 정보만으로 충분)
                    // 양방향 그래프이므로, 한 번만 추가해도 됨
                    cities.get(i).add(j);
                }
            }
        }

        List<Integer> mustCities = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mustCities.add(Integer.parseInt(st.nextToken()));
        }

        // 여행 계획이 없거나 도시가 하나면 무조건 가능
        if (mustCities.size() <= 1) {
            System.out.println("YES");
            return;
        }

        // BFS 시작
        Deque<Integer> dq = new ArrayDeque<>();
        Set<Integer> visitedCities = new HashSet<>();

        int startCity = mustCities.get(0);
        dq.offerLast(startCity);
        visitedCities.add(startCity); // [수정] 시작 노드를 큐에 넣을 때 바로 방문 처리

        while (!dq.isEmpty()) {
            int now = dq.pollFirst();

            for (int city : cities.get(now)) {
                if (!visitedCities.contains(city)) {
                    visitedCities.add(city); // 큐에 넣기 전에 방문 처리
                    dq.offerLast(city);
                }
            }
        }

        // 모든 계획 도시들이 방문되었는지 확인
        for (int city : mustCities) {
            if (!visitedCities.contains(city)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}