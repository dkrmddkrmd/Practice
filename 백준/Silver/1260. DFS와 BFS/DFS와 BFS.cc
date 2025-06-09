#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;

vector<vector<int>> nodes_dfs;
vector<vector<int>> nodes_bfs;
vector<bool> visited_dfs;
vector<bool> visited_bfs;

void dfs(int node) {
	visited_dfs[node] = true;
	cout << node << " ";

	for (auto n : nodes_dfs[node]) {
		if (visited_dfs[n] == false)
			dfs(n);
	}
}

void bfs(int node) {
	queue<int> q;
	visited_bfs[node] = true;
	q.push(node);
	cout << node << " ";

	while (!q.empty()) {
		int now = q.front();
		q.pop();

		for (auto n : nodes_bfs[now]) {
			if (visited_bfs[n] == false) {
				q.push(n);
				visited_bfs[n] = true;
				cout << n << " ";
			}
		}
	}

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M, V;

	cin >> N >> M >> V;

	nodes_bfs.resize(N + 1);
	nodes_dfs.resize(N + 1);
	visited_bfs.resize(N + 1, false);
	visited_dfs.resize(N + 1, false);

	int u, v;
	while (M--) {
		cin >> u >> v;
		nodes_bfs[u].push_back(v);
		nodes_dfs[u].push_back(v);
		nodes_bfs[v].push_back(u);
		nodes_dfs[v].push_back(u);
	}

	for (int i = 1; i <= N; i++) {
		sort(nodes_bfs[i].begin(), nodes_bfs[i].end());
	}

	for (int i = 1; i <= N; i++) {
		sort(nodes_dfs[i].begin(), nodes_dfs[i].end());
	}

	dfs(V);

	cout << "\n";

	bfs(V);



	return 0;
}