#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int N, M;
	cin >> N;
	unordered_map<long, long> m;
	int a;
	for (int i = 0; i < N; i++) {
		cin >> a;
		m[a] = i;
	}

	cin >> M;
	for (int i = 0; i < M; i++) {
		cin >> a;
		if (m.find(a) != m.end())
			cout << 1 << " ";
		else
			cout << 0 << " ";
	}
}

