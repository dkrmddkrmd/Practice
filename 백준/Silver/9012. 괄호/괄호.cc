#include<iostream>
#include<stack>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	string str;
	cin >> n;
	while (n--) {
		stack<char> s;
		cin >> str;

		bool isRight = true;
		for (int i = 0; i < str.size(); i++) {
			if (str[i] == '(') {
				s.push('(');
			}
			else {
				if (s.empty()) {
					isRight = false;
					break;
				}
				s.pop();
			}
		}

		if (!s.empty() || !isRight)
			cout << "NO" << "\n";
		else
			cout << "YES" << "\n";
	}

	return 0;
}