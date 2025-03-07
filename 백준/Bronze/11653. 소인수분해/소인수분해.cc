#include <iostream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

int main() {
	int s;
	cin >> s;

	while (s != 1) {
		int check = 1;
		for (int i = 2; i <= sqrt(s); i++) {
			if (s % i == 0) {
				cout << i << "\n";
				s /= i;
				check = 0;
				break;
			}
		}
		if (check == 1) {
		cout << s;
		s = 1;
		}
	}
}