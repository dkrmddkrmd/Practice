#include <iostream>
#include <deque>
#include <queue>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	// queue(0) 원래 있던 원소를 뒤로, stack(1) 현 원소를 그냥 넣지 않고 뒤로

	int N, M;
	cin >> N;
	queue<int> dS; // data structure
	deque<int> arr; // array

	int num;
	for (int i = 0; i < N; i++) {
		cin >> num;
		if (num == 0)
			dS.push(i);
	}

	if (dS.empty()) {
		while (N--)
			cin >> num;
		cin >> M;
		while (M--) {
			cin >> num;
			cout << num << " ";
		}
		return 0;
	}

	int nowPush = dS.front();
	dS.pop();
	for (int i = 0; i < N; i++) {
		cin >> num;
		if (i == nowPush) {
			arr.push_back(num);
			if (!dS.empty()) {
				nowPush = dS.front();
				dS.pop();
			}
		}
	}

	cin >> M;


	int nowNum;
	while (M--) {
		cin >> nowNum;

		cout << arr.back() << " ";
		arr.pop_back();
		arr.push_front(nowNum);

	}

}