#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	long long N, M;
	cin >> N >> M;

	vector<long long> trees(N);
	for (int i = 0; i < N; i++) {
		cin >> trees[i];
	}

	sort(trees.begin(), trees.end());

	long long start = 0;
	long long end = trees[N - 1]; // 가장 높은 나무

	long long ans = 0;

	while (start <= end) {
		long long mid = (start + end) / 2;

		long long sum = 0;
		for (int i = 0; i < N; i++) {
			if (trees[i] > mid)
				sum += (trees[i] - mid);
		}

		if (sum >= M) {
			ans = mid;
			start = mid + 1;
		}
		else {
			end = mid - 1;
		}
	}

	cout << ans;

	return 0;
}
