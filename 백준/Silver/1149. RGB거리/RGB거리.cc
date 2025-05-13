#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int RED = 0;
const int GREEN = 1;
const int BLUE = 2;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<vector<int>> cost(N, vector<int>(3));
    for (int i = 0; i < N; ++i) {
        cin >> cost[i][RED] >> cost[i][GREEN] >> cost[i][BLUE];
    }

    vector<vector<int>> dp(N, vector<int>(3));

    dp[0][RED] = cost[0][RED];
    dp[0][GREEN] = cost[0][GREEN];
    dp[0][BLUE] = cost[0][BLUE];

    for (int i = 1; i < N; ++i) {
        dp[i][RED] = cost[i][RED] + min(dp[i - 1][GREEN], dp[i - 1][BLUE]);
        dp[i][GREEN] = cost[i][GREEN] + min(dp[i - 1][RED], dp[i - 1][BLUE]);
        dp[i][BLUE] = cost[i][BLUE] + min(dp[i - 1][RED], dp[i - 1][GREEN]);
    }

    cout << min({ dp[N - 1][RED], dp[N - 1][GREEN], dp[N - 1][BLUE] }) << endl;

    return 0;
}