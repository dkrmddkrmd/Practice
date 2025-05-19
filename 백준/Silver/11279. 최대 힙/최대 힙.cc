#include <iostream>
#include <queue>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;
	priority_queue<long long> q;

	long long num;
	for (int i = 0; i < N; i++)
	{
		cin >> num;
		if (num == 0) {
			if (q.empty()) {
				cout << 0 << "\n";
				continue;
			}
			else {
				long long ans = q.top();
				cout << ans << "\n";
				q.pop();
			}
		}
		else {
			q.push(num);
		}
	}

	return 0;
}