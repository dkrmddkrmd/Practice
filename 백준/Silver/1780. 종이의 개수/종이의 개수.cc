#include<iostream>
#include<vector>

using namespace std;

vector<vector<int>> v;
int minusOne = 0;
int zero = 0;
int plusOne = 0;

void myFun(int x,int y, int size) {
	int nowVal = v[x][y];
	bool isSame = true;

	for (int i = x; i < x + size; i++) {
		for (int j = y; j < y + size; j++) {
			if (nowVal != v[i][j]) {
				isSame = false;
				break;
			}
		}
		if (!isSame)
			break;
	}

	if (!isSame) {
		for (int i = x; i < x + size; i += (size / 3)) {
			for (int j = y; j < y + size; j += (size / 3))
				myFun(i, j, size / 3);
		}
	}
	else {
		if (nowVal == -1) {
			minusOne += 1;
		}
		else if(nowVal == 0) {
			zero += 1;
		}
		else if(nowVal == 1) {
			plusOne += 1;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);


	int N;
	cin >> N;

	v.resize(N);
	for (int i = 0; i < N; i++)
		v[i].resize(N);

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++)
			cin >> v[i][j];
	}
	
	myFun(0, 0, N);
	cout << minusOne << "\n" << zero << "\n" << plusOne;


	return 0;
}
