#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int a, b, c;
	cin >> a;

	for (int i = 0; i < a; i++) {
		cin >> b >> c;
		int minVal = min(b, c);
		int maxVal = max(b, c);
		for (int j = maxVal; ; j += maxVal) {
			if (j % minVal == 0) {
				cout << j << "\n";
				break;
			}
		}
	}

	return 0;
}