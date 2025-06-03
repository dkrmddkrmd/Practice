#include<iostream>
#include<queue>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	priority_queue<long long, vector<long long>, greater<>> q;

	int N;
	cin >> N;

	int num;
	while (N--) {
		cin >> num;
		if (num == 0) {
			if (q.empty()) {
				cout << 0 << "\n";
				continue;
			}
			else {
				cout << q.top() << "\n";
				q.pop();
				continue;
			}
		}
		else {
			q.push(num);
		}
	}

	return 0;
}