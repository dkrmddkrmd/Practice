#include <iostream>
#include <unordered_map>
#include<string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M, num;
	unordered_map<int, int> m;

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> num;
		if (m.find(num) != m.end()) {
			m[num]++;
		}
		else
			m[num] = 1;
	}

	cin >> M;
	for (int i = 0; i < M; i++) {
		cin >> num;
		cout << m[num] << " ";
	}
}