#include <iostream>
#include <cmath>
using namespace std;

bool isPrime(long long n) {
	if (n < 2)
		return false;
	int num = sqrt(n);
	for (long long i = 2; i <= num; i++) {
		if (n % i == 0)
			return false;
	}
	return true;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	long long n;
	cin >> n;
	long long num;
	for (long long i = 0; i < n; i++) {
		cin >> num;
		for (long long j = num; ; j++) {
			if (isPrime(j) == true) {
				cout << j << "\n";
				break;
			}
		}
	}


	return 0;
}