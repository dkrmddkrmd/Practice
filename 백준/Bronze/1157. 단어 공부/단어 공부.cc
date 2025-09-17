#include <iostream>
#include<vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	// 65 97

	string a;
	cin >> a;

	vector<int> v(26, 0);

	int len = a.size();
	for (int i = 0; i < len; i++) {
		int now = a[i] - 0;
		if (now >= 65 && now <= 91) {
			v[now - 65]++;
		}
		else {
			v[now - 97]++;
		}
 	} 

	int high = -1;
	int spell;
	bool isSame = false;
	for (int i = 0; i < 26; i++) {
		if (v[i] > high) {
			high = v[i];
			spell = i;
			isSame = false;
		}
		else if (v[i] == high)
			isSame = true;
	}

	

	if (isSame) {
		cout << "?";
		return 0;
	}
	else {
		cout << char('A' + spell);
	}

	return 0;
}