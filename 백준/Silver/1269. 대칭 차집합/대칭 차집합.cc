#include <iostream>
#include <unordered_map>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M;
	cin >> N >> M;
	unordered_map<int, int> m;
	vector<int> result;

	int a;
	for (int i = 0; i < N; i++) {
		cin >> a;
		m[a] = 1; // 1이며는 안 겹치는거
	}

	for (int i = 0; i < M; i++) {
		cin >> a;
		if (m.find(a) != m.end()) {
			m[a] = 0;
		}
		else {
			result.push_back(a);
		}
	}

	for (auto i : m) {
		if (i.second == 1)
			result.push_back(i.first);
	}

	cout << result.size();

	return 0;
}