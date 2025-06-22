#include<iostream>
#include<vector>

using namespace std;

vector<vector<int>> v;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	v.resize(N, vector<int>(2));
	//첫번째는 num값, 두번째는 dp값

	int num;
	cin >> num;
	v[0][0] = num;
	v[0][1] = 1;
	if (N == 1) {
		cout << 1;
		return 0;
	}

	int totalMaxVal = 1;
	for (int i = 1; i < N; i++) {
		cin >> num;
		v[i][0] = num;
		int maxVal = 1;
		bool isBigger = false;
		for (int j = 0; j <= i; j++) {
			if (v[j][0] < num) {
				isBigger = true;
				maxVal = max(maxVal, v[j][1]);
			}
		}
		if (!isBigger) {
			v[i][1] = 1;
			continue;
		}
		else {
			v[i][1] = maxVal + 1;
			totalMaxVal = max(totalMaxVal, v[i][1]);
		}
	}

	cout << totalMaxVal;

	return 0;
}
