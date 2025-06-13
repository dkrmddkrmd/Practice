#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> dp(N + 1, 0);

    for (int i = 2; i <= N; i++) {
        // 1. 1을 빼는 경우
        dp[i] = dp[i - 1] + 1;

        // 2. 2로 나누어 떨어지는 경우
        if (i % 2 == 0) {
            dp[i] = min(dp[i], dp[i / 2] + 1);
        }

        // 3. 3으로 나누어 떨어지는 경우
        if (i % 3 == 0) {
            dp[i] = min(dp[i], dp[i / 3] + 1);
        }
    }

    cout << dp[N];

    return 0;
}