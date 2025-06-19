#include<iostream>
#include<vector>
#include<algorithm> // max 사용

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	vector<int> quant(n + 1, 0);
	vector<int> totalQuant(n + 1, 0);

	if (n >= 1) {
		cin >> quant[1];
		totalQuant[1] = quant[1];
	}
	if (n >= 2) {
		cin >> quant[2];
		totalQuant[2] = quant[1] + quant[2];
	}
	for (int i = 3; i <= n; i++) {
		cin >> quant[i];
		totalQuant[i] = max({
			totalQuant[i - 1],  // 이번 잔을 안 마시는 경우
			totalQuant[i - 2] + quant[i],  // i-1을 안 마신 경우
			totalQuant[i - 3] + quant[i - 1] + quant[i]  // i-2를 안 마신 경우
			});
	}
	cout << totalQuant[n];
	return 0;
}
