#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

const int Max = 1000000;
vector<bool> v(Max + 1, true);

void sieve() {
	v[0] = v[1] = false;
	for (int i = 2; i * i <= Max; i++) {
		if (v[i]) {
			for (int j = i * i; j <= Max; j += i)
				v[j] = false;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	sieve();

	int t, n;
	cin >> t;
	while (t--) {
		cin >> n;
		int gold = 0;

		if (v[2] == true && v[n - 2] == true)
			gold++;

		for (int i = 3; i <= n / 2; i+= 2) {
			if (v[i] == true && v[n - i] == true)
				gold++;
		}

		cout << gold << "\n";
	}

	return 0;
}