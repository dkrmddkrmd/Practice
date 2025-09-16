#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int N, K;
	cin >> N >> K;
	int nowAns = 0;

	for (int i = 1; i <= N; i++) {
		if (N % i == 0) {
			nowAns++;
			if (nowAns == K) {
				cout << i;
				return 0;
			}
		}
	}

	cout << 0;

	return 0;
}