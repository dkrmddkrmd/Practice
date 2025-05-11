#include <iostream>
#include <vector>

#define MAX 1000001
#define MOD 15746

using namespace std;

int main() {
	int N;
	cin >> N;
	if (N == 1)
	{
		cout << 1;
		return 0;
	}
	if (N == 2)
	{
		cout << 2;
		return 0;
	}

	vector<int> v(MAX);
	v[0] = 0;
	v[1] = 1;
	v[2] = 2;

	for (int i = 3; i <= N; i++) {
		v[i] = (v[i - 1] + v[i - 2]) % MOD;
	}

	cout << v[N];

	return 0;
}