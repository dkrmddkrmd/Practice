#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;

vector<vector<int>> nodes;
vector<int> visited;
int order = 1;

void bfs(int node) {
	queue<int> q;

	visited[node] = order++;
	q.push(node);

	while (!q.empty()) {
		int now = q.front();
		q.pop();

		for (auto n : nodes[now]) {
			if (visited[n] == 0) {
				visited[n] = order++;
				q.push(n);
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M, R;
	cin >> N >> M >> R;

	nodes.resize(N + 1);
	visited.resize(N + 1, 0);

	int u, v;
	while (M--) {
		cin >> u >> v;
		nodes[u].push_back(v);
		nodes[v].push_back(u);
	}

	for (int i = 1; i <= N; i++)
		sort(nodes[i].begin(), nodes[i].end());

	bfs(R);

	for (int i = 1; i <= N; i++)
		cout << visited[i] << "\n";

	return 0;
}