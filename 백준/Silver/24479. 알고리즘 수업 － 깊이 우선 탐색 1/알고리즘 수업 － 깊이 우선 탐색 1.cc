#include<iostream>
#include<vector>
#include<stack>
#include<algorithm>

using namespace std;

vector<int> order;
vector<vector<int>> edge;
int nowOrder = 1;

void dfs(int n) {
	order[n] = nowOrder++;

	for (auto a : edge[n]) {
		if (order[a] == 0) {
			dfs(a);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M, R;
	cin >> N >> M >> R;

	order.assign(N + 1, 0);
	edge.assign(N + 1, vector<int>());

	int i, j;
	while (M--) {
		cin >> i >> j;
		edge[i].push_back(j);
		edge[j].push_back(i);
	}

	for (int i = 1; i <= N; i++) {
		sort(edge[i].begin(), edge[i].end());
	}

	dfs(R);

	for (int i = 1; i <= N; i++) {
		cout << order[i] << "\n";
	}

	return 0;
}