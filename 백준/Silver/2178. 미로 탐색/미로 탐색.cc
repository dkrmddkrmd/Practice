#include<iostream>
#include<vector>
#include<queue>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	//right, up, left, down
	int dx[] = { 1, 0, -1, 0 };
	int dy[] = { 0, 1, 0, -1 };

	int Y, X;
	cin >> Y >> X;

	vector<vector<int>> v(Y, vector<int>(X, 0));
	vector<vector<int>> road(Y, vector<int>(X, 0));

	for (int i = 0; i < Y; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < s.length(); j++)
			v[i][j] = s[j] - '0';
	}

	queue<pair<int, int>> q;
	q.push({0, 0});
	road[0][0] = 1;

	while (!q.empty()) {
		int y = q.front().first;
		int x = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny >= 0 && ny < Y && nx >= 0 && nx < X) {
				if (v[ny][nx] == 1 && road[ny][nx] == 0) {
					road[ny][nx] = road[y][x] + 1;
					q.push({ ny, nx });
				}
			}
		}
	}

	cout << road[Y - 1][X - 1];

	return 0;
}