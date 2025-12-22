import java.util.*;
import java.io.*;

public class Main{
    static int n,m;
    static int[] arr;
    static List<List<Integer>> lists;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        lists = new ArrayList<>();
        for (int i = 0; i < 4 * (n + 1); i++) {
            lists.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 1, n); // 트리 생성 완료

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken()); // k번째 수를 찾아라!

            // ==========================================
            // (★) 여기가 수정된 핵심 파트입니다.
            // 정답(숫자값)의 범위: -10억 ~ 10억
            // ==========================================
            int left = -1000000000;
            int right = 1000000000;
            int ans = 0;

            while (left <= right) {
                int mid = (left + right) / 2; // "정답이 mid일까?"라고 가정

                // 트리야, first~last 범위 안에 mid보다 작거나 같은 수가 몇 개니?
                if (query(1, 1, n, first, last, mid) < k) {
                    // 개수가 K개보다 적네? -> mid가 너무 작다. 더 큰 수를 찾아보자.
                    left = mid + 1;
                } else {
                    // 개수가 K개 이상이네? -> mid가 정답 후보! (혹은 더 작은 수도 가능할지 확인)
                    ans = mid;
                    right = mid - 1;
                }
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    static void init(int node, int start, int end) {
        // 1. 리프 노드 (종료 조건)
        if (start == end) {
            lists.get(node).add(arr[start]);
            return;
        }

        // 2. 자식들 먼저 만들고 오기 (재귀)
        int mid = (start + end) / 2;
        init(node * 2, start, mid);       // 왼쪽 자식 (이미 정렬돼서 돌아옴)
        init(node * 2 + 1, mid + 1, end); // 오른쪽 자식 (이미 정렬돼서 돌아옴)

        // 3. 자식들을 합치기 (투 포인터) -> 이게 바로 머지 소트의 핵심!
        List<Integer> parent = lists.get(node);
        List<Integer> left = lists.get(node * 2);
        List<Integer> right = lists.get(node * 2 + 1);

        int l = 0, r = 0; // 왼쪽, 오른쪽 리스트를 가리키는 포인터

        // 두 리스트를 비교하며 작은 순서대로 넣기
        while (l < left.size() && r < right.size()) {
            if (left.get(l) <= right.get(r)) {
                parent.add(left.get(l++));
            } else {
                parent.add(right.get(r++));
            }
        }

        // 남은 데이터 털어 넣기
        while (l < left.size()) parent.add(left.get(l++));
        while (r < right.size()) parent.add(right.get(r++));
    }

    // node: 현재 노드, s/e: 노드 범위, a/b: 우리가 찾는 쿼리 범위, val: 기준값(mid)
    static int query(int node, int s, int e, int a, int b, int val) {
        // 1. 범위 밖이면 볼 필요 없음
        if (b < s || e < a) return 0;

        // 2. 쿼리 범위 안에 노드가 쏙 들어오면? (핵심)
        if (a <= s && e <= b) {
            // 이 노드의 리스트(정렬됨)에서 val보다 작거나 같은 게 몇 개인지 셈
            // 여기서 또 이분탐색(upper_bound) 사용
            return upperBound(lists.get(node), val);
        }

        // 3. 걸쳐 있으면 자식한테 물어봄
        int mid = (s + e) / 2;
        return query(node * 2, s, mid, a, b, val) + query(node * 2 + 1, mid + 1, e, a, b, val);
    }

    // 리스트에서 key보다 작거나 같은 수의 개수 찾기
    static int upperBound(List<Integer> list, int key) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // left가 곧 개수가 됨 (인덱스니까)
    }
}


