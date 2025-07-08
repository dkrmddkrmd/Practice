#include<iostream>
#include<vector>

using namespace std;

int main() {
	string A;
	string B;

	cin >> A;
	cin >> B;

	int aLen = A.length();
	int bLen = B.length();

	vector<vector<int>> dp(aLen + 1, vector<int>(bLen + 1, 0));
	
	for (int i = 1; i <= aLen; i++) {
		for (int j = 1; j <= bLen; j++) {
			if (A[i - 1] == B[j - 1]) {
				dp[i][j] = dp[i - 1][j - 1] + 1;
			}
			else {
				dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}

	cout << dp[aLen][bLen];

	return 0;
}