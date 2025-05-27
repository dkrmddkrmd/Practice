#include<iostream>

#define MAX 501

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int arr[MAX][MAX] = { 0, };

    int N, num;
	cin >> N;
	
	cin >> num;
	if (N == 1) {
		cout << num;
		return 0;
	}
	arr[1][1] = num;

	int num2;
	cin >> num >> num2;

	arr[2][1] = num + arr[1][1];
	arr[2][2] = num2 + arr[1][1];
	if (N == 2) {
		if (arr[2][1] <= arr[2][2]) {
			cout << arr[2][2];
			return 0;
		}
		else {
			cout << arr[2][1];
			return 0;
		}
	}
	

	for (int i = 3; i <= N; i++) {
		cin >> num;
		arr[i][1] = arr[i - 1][1] + num;
		for (int j = 2; j <= i - 1; j++) {
			cin >> num;
			int plus = arr[i - 1][j - 1] >= arr[i - 1][j] ? arr[i - 1][j - 1] : arr[i - 1][j];
			arr[i][j] = num + plus;
		}
		cin >> num;
		arr[i][i] = arr[i - 1][i - 1] + num;
	}

	int max = -1;
	for (int i = 1; i <= N; i++) {
		if (arr[N][i] >= max)
			max = arr[N][i];
	}

	cout << max;
	return 0;
}