#include <iostream>
#include <cmath>
#include <vector>
#include<algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int a;
	cin >> a;
	vector<int> v1(a), v2(a);

	for (int i = 0; i < a; i++) {
		cin >> v1[i];
	}

	for (int i = 0; i < a; i++) {
		cin >> v2[i];
	}

	sort(v1.begin(), v1.end());
	sort(v2.begin(), v2.end(), greater<>());

	long long sum = 0;
	for (int i = 0; i < a; i++) {
		sum += v1[i] * v2[i];
	}

	cout << sum;

	return 0;
}