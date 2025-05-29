#include<iostream>
#include<vector>

using namespace std;

int blue = 0;
int white = 0;

bool isSameColor(int x, int y, int size, vector<vector<int>> &v) {
	int firstColor = v[x][y];
	for (int i = x; i < x + size; i++) {
		for (int j = y; j < y + size; j++) {
			if (v[i][j] != firstColor)
				return false;
		}
	}
	return true;
}

void divide(int x, int y, int size, vector<vector<int>> &v) {
	if (isSameColor(x, y, size, v)) {
		if (v[x][y] == 1)
			blue++;
		else
			white++;
		return;
	}

	divide(x, y, size / 2, v);
	divide(x + size / 2, y, size / 2, v);
	divide(x, y + size / 2, size / 2, v);
	divide(x + size / 2, y + size / 2, size / 2, v);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, num;

	cin >> N;

	vector<vector<int>> v(N, vector<int>(N));

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> num;
			v[i][j] = num;
		}
	}

	divide(0, 0, N, v);

	cout << white << "\n" << blue;

	return 0;
}