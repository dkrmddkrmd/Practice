#include<iostream>
#include<stack>
#include<string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	string s;
	getline(cin, s);
	do {
		stack<char> s1;
		bool isOk = true;

		for (auto ch : s) {
			switch (ch) {
			case '(':
				s1.push(ch);
				break;
			case ')':
				if (s1.empty()) {
					isOk = false;
					break;
				}
				else {
					if (s1.top() != '(') {
						isOk = false;
						break;
					}
					s1.pop();
				}
				break;
			case '[':
				s1.push(ch);
				break;
			case ']':
				if (s1.empty()) {
					isOk = false;
					break;
				}
				else {
					if (s1.top() != '[') {
						isOk = false;
						break;
					}
					s1.pop();
				}
				break;
			default:
				break;
			}

			if (!isOk)
				break;
		}

		if (!isOk || !s1.empty())
			cout << "no" << "\n";
		else
			cout << "yes" << "\n";

		getline(cin, s);
	} while (s != ".");

	return 0;
}