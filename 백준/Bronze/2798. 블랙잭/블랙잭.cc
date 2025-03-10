#include <iostream>
#include <algorithm>  // sort 함수 사용

using namespace std;

int main() {
	int M, N;
	cin >> M >> N;

	int arr[100] = { 0, };
	int ans = 0;

	for (int i = 0; i < M; i++)
		cin >> arr[i];


	for (int i = 0; i < M - 2; i++) {
		for (int j = i + 1; j < M - 1; j++) {
			for (int k = j + 1; k < M; k++) {
				int newAns = arr[i] + arr[j] + arr[k];
				if (newAns > ans && newAns <= N)
					ans = newAns;
			}
		}
	}

	cout << ans;
}
