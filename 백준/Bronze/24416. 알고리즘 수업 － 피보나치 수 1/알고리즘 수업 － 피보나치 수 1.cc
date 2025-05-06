#include <iostream>
#include <vector>

using namespace std;

int one = 0;
int two = 0;

int fiv(int num) {
	if (num == 1 || num == 2) {
		one++;
		return 1;
	}
	return fiv(num - 1) + fiv(num - 2);
}

int fibonacci(int num, vector<int> &f) {
	f[1] = 1;
	f[2] = 1;
	for (int i = 3; i <= num; i++) {
		two++;
		f[i] = f[i - 2] + f[i - 1];
	}
	return f[num];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	vector<int> v(N + 1);
	for (int i = 0; i < N + 1; i++)
		v[i] = 0;
	fiv(N);
	fibonacci(N, v);

	cout << one << " " << two;

	return 0;
}