#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int N;
	cin >> N;
	int nowNum = 1;
	stack<int> s;

	while (N--) {
		int num;
		cin >> num;
		if (num == nowNum) {
			nowNum++;
			continue;
		}
		else {
			while (!s.empty() && s.top() == nowNum) {
				nowNum++;
				s.pop();
			}
			if (num == nowNum) {
				nowNum++;
				continue;
			}
			else
				s.push(num);
		}
	}

	while (!s.empty() && s.top() == nowNum) {
		s.pop();
		nowNum++;

	}

	if (s.empty())
		cout << "Nice";
	else
		cout << "Sad";

	return 0;
}