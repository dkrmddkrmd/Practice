#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main() {
	string s;
	int Nums = 0;
	cin >> s;

	for (int i = 0; i < s.length(); i++) {
		Nums++;
		if (s[i] == '-')
			Nums--;
		else if (s[i] == '=') {
			if (i >= 2) {
				if (s[i - 1] == 'z' && s[i - 2] == 'd') {
					Nums -= 2;
					continue;
				}
			}
			Nums--;
		}
		else if (i >= 1 && s[i] == 'j')
			if (s[i - 1] == 'l' || s[i - 1] == 'n')
				Nums--;
	}

	cout << Nums;
}