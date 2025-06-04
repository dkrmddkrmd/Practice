#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> nodes;
vector<int> visited;
int order = 1;

void dfs(int node) {
    visited[node] = order++;

    for (int next : nodes[node]) {
        if (visited[next] == 0)
            dfs(next);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M, R;
    cin >> N >> M >> R;

    nodes.resize(N + 1);
    visited.resize(N + 1, 0);

    for (int i = 0; i < M; ++i) {
        int u, v;
        cin >> u >> v;
        nodes[u].push_back(v);
        nodes[v].push_back(u);
    }

    for (int i = 1; i <= N; ++i)
        sort(nodes[i].begin(), nodes[i].end());

    dfs(R);

    for (int i = 1; i <= N; ++i)
        cout << visited[i] << "\n";

    return 0;
}