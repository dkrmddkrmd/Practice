#include<iostream>
#include<vector>
#include<queue>

using namespace std;

vector<vector<int>> nodes;
vector<bool> visited;

void bfs(int node) {
	visited[node] = true;

	for (auto n : nodes[node]) {
		if (visited[n] == false)
			bfs(n);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int Comps, Nets;

	cin >> Comps;
	cin >> Nets;

	nodes.resize(Comps + 1);
	visited.resize(Comps + 1, false);

	int u, v;
	while (Nets--) {
		cin >> u >> v;
		nodes[u].push_back(v);
		nodes[v].push_back(u);
	}

	bfs(1);

	int virus = 0;
	for (int i = 1; i <= Comps; i++) {
		if (visited[i] == true)
			virus++;
	}

	cout << virus - 1;

	return 0;
}