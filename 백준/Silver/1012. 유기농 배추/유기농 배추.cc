#include<iostream>
#include<vector>

using namespace std;

void dfs(int x, int y, int maxX, int maxY, vector<vector<int>>& v, vector<vector<bool>>& isTrue) {
	if (x < 0 || x > maxX || y < 0 || y > maxY) return;
	if (v[x][y] == 0 || isTrue[x][y]) return;

	isTrue[x][y] = true; // 방문 체크 추가

	dfs(x - 1, y, maxX, maxY, v, isTrue);
	dfs(x + 1, y, maxX, maxY, v, isTrue);
	dfs(x, y - 1, maxX, maxY, v, isTrue);
	dfs(x, y + 1, maxX, maxY, v, isTrue);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int T, M, N, K;
	cin >> T;
	while (T--) {
		cin >> M >> N >> K;
		vector<vector<int>> v(N, vector<int>(M, 0));
		vector<vector<bool>> isTrue(N, vector<bool>(M, false));
		int x, y;
		int earthWorm = 0;

		while (K--) {
			cin >> x >> y;
			v[y][x] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (v[i][j] == 1 && isTrue[i][j] == false) {
					dfs(i, j, N - 1, M - 1, v, isTrue);
					earthWorm++;
				}
			}
		}
		cout << earthWorm << "\n";
	}

	return 0;
}