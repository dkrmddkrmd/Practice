#include<iostream>

#define MAX 100001

using namespace std;

long long dp[MAX] = { 0, };

int main() {
	int N;

	cin >> N;

	long long Max = -1001;
	long long num;
	long long highest = -1001;
	for (int i = 1; i <= N; i++) {
		cin >> num;
		Max = max(Max + num, num);
		highest = max(highest, Max);
	}
	cout << highest;

	return 0;
}