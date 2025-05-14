#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<int> v(N);

    int num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        v[i] = num;
    }

    sort(v.begin(), v.end());

    int nowSum = 0;
    int sum = 0;
    for (int i = 0; i < N; i++) {
        nowSum += v[i];
        sum += nowSum;
    }

    cout << sum;

    return 0;
}