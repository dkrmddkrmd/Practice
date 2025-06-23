#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int K, N;
	cin >> K >> N;

	vector<long long> v(K);

	long long low = 1;
	long long high = 0;

	for (int i = 0; i < K; i++) {
		cin >> v[i];
		high = max(high, v[i]);
	}

	long long result = 0;
	while (low <= high) {
		long long mid = (low + high) / 2;

		long long sum = 0;
		for (int i = 0; i < K; i++) {
			sum += v[i] / mid;
		}
		if (sum >= N) {
			result = max(result, mid);
			low = mid + 1;
		}
		else {
			high = mid - 1;
		}
	}

	cout << result;
	return 0;
	
}