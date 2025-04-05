#include <iostream>
#include <vector>

using namespace std;


long long divide(long long x, long long y) {
	while (y != 0) {
		long long temp = y;
		y = x % y;
		x = temp;
	}
	return x;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	long long minNum, maxNum, minGCD, first, second, dis;
	cin >> first;
	cin >> second;
	maxNum = max(first, second);
	minNum = min(first, second);
	dis = second - first;
	for (int i = 0; i < N - 2; i++) {
		first = second;
		cin >> second;
		maxNum = max(maxNum, second);
		minNum = min(minNum, second);

		if (i == 0) {
			long long nowDis = second - first;
			minGCD = divide(dis, nowDis);
			continue;
		}
		long long nowDis = second - first;
		minGCD = divide(minGCD, nowDis);
	}

	cout << (maxNum - minNum) / minGCD + 1 - N;
	


	return 0;
}