#include<iostream>
#include <vector>

using namespace std;

int main() {
	int N, K;
	cin >> N >> K;

	vector<int> v(N);


	int num;

	for (int i = 0; i < N; i++) {
		cin >> num;
		v[i] = num;
	}
	// 1 10 100 1000

	int ansCoin = 0;
	for (int i = N - 1; i >= 0; i--) {
		if (v[i] > K)
			continue;
		int nowCoin = 0;
		while (K - v[i] >= 0) {
			K -= v[i];
			nowCoin++;
		}
		ansCoin += nowCoin;
		if (K == 0) {
			cout << ansCoin;
			return 0;
		}
	}


	return 0;
}