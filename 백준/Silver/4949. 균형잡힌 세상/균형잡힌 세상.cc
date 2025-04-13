#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	while (true) {
		string str;
		getline(cin, str);
		if (str == ".")
			return 0;
		int strSize = str.size();
		stack<char> left;

		bool isValid = true;
		for (int i = 0; i < strSize; i++) {
			if (str[i] == '(' || str[i] == '[') {
				left.push(str[i]);
				continue;
			}
			else if (str[i] == ')') {
				if (left.empty()) {
					isValid = false;
					break;
				}
				char c = left.top();
				left.pop();
				if (c == '(')
					continue;
				else {
					isValid = false;
					break;
				}
			}
			else if (str[i] == ']') {
				if (left.empty()) {
					isValid = false;
					break;
				}
				char c = left.top();
				left.pop();
				if (c == '[')
					continue;
				else {
					isValid = false;
					break;
				}
			}
		}
		if (!left.empty())
			isValid = false;

		if (isValid)
			cout << "yes" << "\n";
		else
			cout << "no" << "\n";
	}
	

	return 0;
}