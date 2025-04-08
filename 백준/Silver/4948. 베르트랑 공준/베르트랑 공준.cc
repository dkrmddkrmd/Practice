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

	int n;
	while (true) {
		cin >> n;
		if (n == 0)
			return 0;
		int primeNum = 0;
		for (int i = n + 1; i <= 2 * n; i++) {
			if (isPrime(i) == true)
				primeNum++;
		}
		cout << primeNum << "\n";
	}

	return 0;
}