#include<iostream>
#include<algorithm>
#include<cstdlib>
#include<string>

using namespace std;

int main(void) {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int A[100][100];
	int B[100][100];

	int N, M;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> A[i][j];
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> B[i][j];
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++)
			cout << A[i][j] + B[i][j] << " ";
		cout << "\n";
	}

	return 0;
}