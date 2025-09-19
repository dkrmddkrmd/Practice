#include<iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int M, N;

	int arr[100001] = { 0, };

	cin >> N >> M;

	int num;
	for (int i = 1; i <= N; i++) {
		cin >> num;
		arr[i] = num + arr[i-1];
	}

	int i, j;
	while (M--) {
		cin >> i >> j;
		cout << arr[j] - arr[i - 1] <<"\n";
	}

	return 0;
}