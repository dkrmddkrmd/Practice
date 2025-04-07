#include <iostream>
#include <cmath>
using namespace std;

bool isPrime(int n) {
	if (n < 2)
		return false;
	for (int i = 2; i * i <= n; i++) {
		if (n % i == 0)
			return false;
	}
	return true;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int M, N;
	cin >> M >> N;
	for (int i = M; i <= N; i++) {
		if (isPrime(i) == true)
			cout << i << "\n";
	}

	return 0;
}