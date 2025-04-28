#include <iostream>
#include <vector>
#define MAX 9

using namespace std;

void dfs(int n, int start);

int N, M;
vector<int> v;
vector<bool> v2(MAX);

void dfs(int n, int start) {
	if (n == M) {
		for (auto num : v)
			cout << num << " ";
		cout << "\n";
		return;
	}

	for (int i = start; i <= N; i++) {
		if (!v2[i]) {
			v2[i] = true;
			v.push_back(i);
			dfs(n + 1, i+1);
			v.pop_back();
			v2[i] = false;
		}
	}
}


int main() {
	cin >> N >> M;

	dfs(0, 1);

	return 0;
}