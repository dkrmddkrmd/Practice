#include <iostream>

using namespace std;

long long divide(long long x, long long y) {
	while (y != 0) {
		int temp = y;
		y = x % y;
		x = temp;
	}
	return x;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	long long a, b;
	cin >> a >> b;
	cout << a * b / divide(a, b);

	return 0;
}