#include<iostream>

#define MAX 101

using namespace std;

long long dp[MAX] = { 0, };

int main() {
	int T, N;

	dp[1] = 1;
	dp[2] = 1;
	dp[3] = 1;
	dp[4] = 2;
	dp[5] = 2;

	cin >> T;
	while (T--) {
		cin >> N;

		if (dp[N] != 0) {
			cout << dp[N] << "\n";
			continue;
		}

		for (int i = 6; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
		cout << dp[N] << "\n";
	}

	return 0;
}