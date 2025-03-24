#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int N, M, ans = 0;
	cin >> N >> M;
	unordered_map<string, int> m;

	string s;
	for (int i = 0; i < N; i++) {
		cin >> s;
		m[s] = i;
	}

	for (int i = 0; i < M; i++) {
		cin >> s;
		if (m.find(s) != m.end())
			ans++;
	}

	cout << ans;
}
