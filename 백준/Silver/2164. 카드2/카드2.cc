#include <iostream>
#include <deque>

using namespace std;

int main(){
	int N;
	cin >> N;
	deque<int> d;

	for (int i = 1; i <= N; i++)
		d.push_back(i);

	if (N == 1) {
		cout << 1;
		return 0;
	}

	while (N--) {
		d.pop_front();

		if (N == 1) {
			cout << d.back();
			return 0;
		}

		int n = d.front();
		d.push_back(n);
		d.pop_front();
	}

	return 0;
}