#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {

	int n;
	while (1) {
		cin >> n;
		if (n == -1)
			break;
		int sum = 0;
		vector<int> v;
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				sum += i;
				v.push_back(i);
			}
		}
		if (sum == n) {
			cout << n << " = " << v[0];
			for (int i = 1; i < v.size(); i++) {
				cout << " + " << v[i];
			}
			cout << "\n";
		}
		else {
			cout << n << " is NOT perfect.\n";
		}
	}

}