#include <iostream>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;
	while (n--) {
		string s;
		cin >> s;
		int mySize = s.size();
		int isVps = 0;
		bool isReverse = false;
		for (int i = 0; i < mySize; i++) {
			if (s[i] == '(')
				isVps++;
			else {
				isVps--;
				if (isVps < 0) {
					isReverse = true;
					break;
				}
			}
		}
		if (isVps == 0 && !isReverse)
			cout << "YES" << "\n";
		else
			cout << "NO" << "\n";
	}

	return 0;
}