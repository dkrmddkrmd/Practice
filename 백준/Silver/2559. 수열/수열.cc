#include<iostream>

#define MAX 100001

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int arr[MAX];
	arr[0] = 0;

	int N, K;
	cin >> N >> K;

	int num;
	int maxVal;
	for (int i = 1; i <= N; i++) {
		cin >> num;
		arr[i] = arr[i - 1] + num;
		if (i >= K) {
			if (i == K) {
				maxVal = arr[i];
			}
			else {
				maxVal = max(maxVal, arr[i] - arr[i - K]);
			}
		}
	}

	cout << maxVal;

	return 0;
}
