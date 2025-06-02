#include<iostream>
#define MAX 301

using namespace std;

int arr[MAX]; // 순수한 num값들 저장
int DP[MAX]; // DP값들 저장

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	// 다음 계단 or 다다음 계단, 3번 연속 x, 마지막 계단은 무조건

	// 첫번째 두번째는 무조건 가능
	int num;
	cin >> num;
	if (N == 1) {
		cout << num;
		return 0;
	}
	arr[1] = DP[1] = num;



	cin >> num;
	arr[2] = num;
	DP[2] = arr[1] + arr[2];
	if (N == 2) {
		cout << DP[2];
		return 0;
	}

	cin >> num;
	arr[3] = num;
	DP[3] = (arr[3] + arr[2]) >= (arr[3] + arr[1]) ? (arr[3] + arr[2]) : (arr[3] + arr[1]);
	if (N == 3) {
		cout << DP[3];
		return 0;
	}

	for (int i = 4; i <= N; i++) {
		cin >> num;
		arr[i] = num;
		DP[i] = (arr[i] + arr[i - 1] + DP[i - 3]) >= (arr[i] + DP[i - 2]) ? (arr[i] + arr[i - 1] + DP[i - 3]) : (arr[i] + DP[i - 2]);
		if (N == i) {
			cout << DP[i];
			return 0;
		}
	}



	return 0;
}