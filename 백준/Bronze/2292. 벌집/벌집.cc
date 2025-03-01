#include <iostream>
#include <string>

using namespace std;

int main() {
	int a, ans;
	cin >> a;
	int x = 1;

	for (int i = 0; ; i++) {
		x += 6 * i;
		if (a <= x) {
			ans = i + 1;
			break;
		}
	}

	cout << ans;
}