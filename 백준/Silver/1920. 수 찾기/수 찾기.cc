#include <iostream>
#include <map>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;
	map<int, long long> m;

	int num;
	for (int i = 0; i < N; i++) {
		cin >> num;
		m[num] = 1;
	}

	int M;
	cin >> M;
	while (M--) {
		cin >> num;
		if (m.find(num) == m.end())
			cout << 0 << "\n";
		else
			cout << 1 << "\n";
	}

	return 0;
}