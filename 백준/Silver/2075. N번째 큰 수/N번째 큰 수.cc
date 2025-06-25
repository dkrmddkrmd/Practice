#include <iostream>
#include <queue>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	priority_queue<int, vector<int>, greater<int>> q;

	long long num = N * N;
	int nowVal;
	while (num--) {
		cin >> nowVal;
		q.push(nowVal);
		if (q.size() > N)
			q.pop();
	}

	cout << q.top();

	return 0;
}