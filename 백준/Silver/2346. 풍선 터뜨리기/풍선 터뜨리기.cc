#include <iostream>
#include <deque>
#include <vector>

using namespace std;

int main() {
	int N;
	cin >> N;

	deque<int> d;
	vector<int> v;

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		d.push_back(i + 1);
		v.push_back(num);
	}

	for (int i = 0; i < N - 1; i++) {
		int jump = d.front() - 1;
		cout << d.front() << " ";
		d.pop_front();
		if (v[jump] > 0) {
			for (int j = 0; j < v[jump] - 1; j++) {
				d.push_back(d.front());
				d.pop_front();
			}
		}
		else {
			for (int j = 0; j < -v[jump]; j++) {
				d.push_front(d.back());
				d.pop_back();
			}
		}
	}
	cout << d.front();

	return 0;
}