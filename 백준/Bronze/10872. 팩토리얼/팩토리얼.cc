#include <iostream>
#include <cmath>

using namespace std;

int main() {
	int N;
	cin >> N;

	long long int mul = 1;
	for (int i = 1; i <= N; i++)
		mul *= i;
	cout << mul;
}