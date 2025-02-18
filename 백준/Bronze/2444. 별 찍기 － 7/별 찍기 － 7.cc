#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main() {
	int a;

	cin >> a;


	for (int i = 0; i < a; i++) {
		for (int j = a - i - 1; j > 0; j--)
			cout << " ";
		for (int k = 2 * i + 1; k > 0; k--)
			cout << "*";
		cout << "\n";
	}

	for (int i = 1; i < a; i++) {
		for (int j = i; j > 0; j--)
			cout << " ";
		for (int j = 2 * (a - i) - 1; j > 0; j--)
			cout << "*";
		cout << "\n";
	}

}