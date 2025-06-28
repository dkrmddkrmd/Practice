#include<iostream>
#include<vector>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int N, M;
	cin >> N >> M;

	vector<vector<int>> v1(N + 1, vector<int>(N + 1, 0));
	vector<vector<int>> v2(N + 1, vector<int>(N + 1, 0));

	for (int i = 1; i <= N; i++) {
		int nowVal;
		int nowSum = 0;
		for (int j = 1; j <= N; j++) {
			cin >> nowVal;
			v1[i][j] = nowVal;
			nowSum += nowVal;
			v2[i][j] = nowSum;
		}
	}

	int x1, y1, x2, y2;

	while (M--) {
		int ans = 0;
		cin >> x1 >> y1 >> x2 >> y2;
		for (int i = x1; i <= x2; i++) {
			ans += (v2[i][y2] - v2[i][y1 - 1]);
		}
		cout << ans << "\n";
	}

	return 0;
}