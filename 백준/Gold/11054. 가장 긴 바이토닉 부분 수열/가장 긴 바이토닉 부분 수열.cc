#include<iostream>
#include<vector>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int N;
	cin >> N;

	vector<int> dp(N , 1);
	vector<int> val(N, 0);
	vector<int> down(N, 1);

	int num;
	for (int i = 0; i < N; i++) {
		cin >> num;
		val[i] = num;
		for (int j = 0; j < i; j++) {
			if (val[i] > val[j]) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
	}

	for (int i = N - 1; i >= 0; i--) {
		for (int j = N - 1; j > i; j--) {
			if (val[i] > val[j]) {
				down[i] = max(down[i], down[j] + 1);
			}
		}
	}

	int answer = 0;
	for (int i = 0; i < N; i++) {
		answer = max(answer, dp[i] + down[i] - 1);
	}

	cout << answer;

	return 0;
}