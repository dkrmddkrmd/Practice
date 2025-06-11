#include<iostream>
#include<vector>

using namespace std;

vector<vector<int>> v;

bool mySolve(int x, int y, int size, int num);

void quadTree(int x, int y, int size) {
	bool isSolved = mySolve(x, y, size, v[x][y]);
	if (isSolved) {
		cout << v[x][y];
	}
	else {
		size /= 2;
		cout << "(";
		quadTree(x, y, size);
		quadTree(x, y + size, size);
		quadTree(x + size, y, size);
		quadTree(x + size, y + size, size);
		cout << ")";
	}
}

bool mySolve(int x, int y, int size, int num) {
	for (int i = x; i < x + size; i++) {
		for (int j = y; j < y + size; j++) {
			if (v[i][j] != num)
				return false;
		}
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	v.resize(N, vector<int>(N));

	for (int i = 0; i < N; i++) {
		string row;
		cin >> row;
		for (int j = 0; j < N; j++) {
			v[i][j] = row[j] - '0'; // 문자를 숫자로 변환
		}
	}

	quadTree(0, 0, N);

	return 0;
}