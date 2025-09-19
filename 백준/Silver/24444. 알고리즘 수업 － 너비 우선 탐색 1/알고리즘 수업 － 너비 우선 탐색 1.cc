#include<iostream>
#include<queue>
#include<vector>
#include<algorithm> // sort를 사용하기 위해 필요

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M, R;
	cin >> N >> M >> R;

	// 1. 방문 순서를 저장할 배열 (0으로 자동 초기화)
	// 이 배열이 visited 역할도 겸함 (0 = 방문 안 함)
	vector<int> visit_order(N + 1, 0);
	vector<vector<int>> edge(N + 1);
	int visit_count = 1; // 방문 순서 카운터

	int u, v;
	while (M--) {
		cin >> u >> v;
		edge[u].push_back(v);
		edge[v].push_back(u);
	}

	// 2. (필수!) 문제의 요구사항에 따라 인접 리스트를 오름차순 정렬
	for (int i = 1; i <= N; i++) {
		sort(edge[i].begin(), edge[i].end());
	}

	queue<int> q;

	// 3. (수정) BFS 시작: 큐에 시작 노드 R만 삽입
	q.push(R);
	visit_order[R] = visit_count++; // R을 1번으로 방문 처리

	// 4. 표준 BFS 루프
	while (!q.empty()) {
		int now = q.front();
		q.pop();

		for (int next_node : edge[now]) {
			// (수정) 방문하지 않은(order가 0인) 노드만 큐에 넣음
			if (visit_order[next_node] == 0) {
				visit_order[next_node] = visit_count++; // 새 방문 순서 할당
				q.push(next_node);
			}
		}
	}

	// 5. 1번 노드부터 N번 노드까지의 "방문 순서"를 출력
	for (int i = 1; i <= N; i++) {
		cout << visit_order[i] << "\n";
	}

	return 0;
}