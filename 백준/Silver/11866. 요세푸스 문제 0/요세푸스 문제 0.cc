#include <iostream>
#include <vector>

using namespace std;

void plusPoint(int* point, int N, vector<int>& v) {
	(*point)++;
	if (*point == N)
		*point = 0;
}

int main(){
	int N, K;
	cin >> N >> K;
	vector<int> v;
	for (int i = 1; i <= N; i++)
		v.push_back(i);

	cout << "<";

	int nowPoint = 0;
	int deletes = 0;
	while (deletes != (N - 1)) {
		int jumps = 0;
		while (jumps != K - 1) {
			if (v[nowPoint] == 0) {
				plusPoint(&nowPoint, N, v);
				continue;
			}
			jumps++;
			plusPoint(&nowPoint, N, v);
		}
		while (v[nowPoint] == 0) {
			plusPoint(&nowPoint, N, v);
		}
		cout << v[nowPoint] << ", ";
		v[nowPoint] = 0;
		deletes++;
	}

	for (int i = 0; i < N; i++) {
		if (v[i] != 0) {
			cout << v[i] << ">";
			break;
		}
	}

	return 0;
}