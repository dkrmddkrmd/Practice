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
	unordered_map<string, string> m;
	vector<string> result;

	string s;
	for (int i = 0; i < N; i++) {
		cin >> s;
		m[s] = s;
	}
	for (int i = 0; i < M; i++) {
		cin >> s;
		if (m.find(s) != m.end()) {
			result.push_back(s);
		}
	}

	// 사전순 정렬
	sort(result.begin(), result.end());

	// 출력
	cout << result.size() << "\n";
	for (const auto& name : result) {
		cout << name << "\n";
	}

	return 0;
}