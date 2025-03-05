#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {

	int n, m, count = 0;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> m;
		bool find = true;
		for (int j = 2; j <= m / 2; j++) {
			if (m % j == 0) {
				find = false;
				break;
			}
		}
		if (find && m != 1)
			count++;
	}

	cout << count;

}