#include<algorithm>
#include<cstdlib>
#include<iostream>
#include<string>
#include<cmath>
#include<vector>
#include<numeric>

using namespace std;

int main(void) {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int M, N;
	cin >> M;
	cin >> N;
	int total = 0;
	int min = 0, minval = 0;

	for (int i = M; i <= N; i++) {
		if (i == 1)
			continue;
		int nums = 0;
		for (int j = 1; j * j <= i; j++) {
			if (i % j == 0) {
				nums++;
				if (i % (i / j) == 0)
					nums++;
			}
		}
		if (nums == 2) {
			if (min == 0) {
				min++;
				minval = i;
			}
			total += i;
		}
	}

	if (total == 0)
		cout << -1;
	else
		cout << total << "\n" << minval;

	return 0;
}