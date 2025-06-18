#include<iostream>
#include<vector>
#include<numeric>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M;
	cin >> N >> M;

	vector<int> v(N + 1);

	v[0] = 0;

	int num;
	for (int i = 1; i <= N; i++) {
		cin >> num;
		v[i] = num + v[i - 1];
	}

	int i, j;
	while (M--) {
		cin >> i >> j;
		cout << v[j] - v[i - 1] << "\n";
	}

	return 0;
}