#include <iostream>
#include <stack>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	stack<int> s;
	int n;
	cin >> n;
	int num;
	while (n--) {
		cin >> num;
		if (num == 0)
			s.pop();
		else
			s.push(num);
	}
	long long m = 0;
	while (!s.empty()) {
		m += s.top();
		s.pop();
	}

	cout << m;

	return 0;
}