#include <iostream>
#include <vector>

using namespace std;

int divide(int x, int y) {
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

	int a, b, c, d;
	cin >> a >> b;
	cin >> c >> d;

	int mom = b * d / divide(b, d);
	int son = a * (mom / b) + c * (mom / d);

	int g = divide(son, mom);
	son /= g;
	mom /= g;
	cout << son << " " << mom;

	


	return 0;
}