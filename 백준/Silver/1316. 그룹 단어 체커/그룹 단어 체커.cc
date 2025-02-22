#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main() {
	bool isWord = true;
	int nums;
	int words = 0;
	string s;
	cin >> nums;

	int alpha[26];
	fill(alpha, alpha + 26, 0);

	for (int i = 0; i < nums; i++) {
		cin >> s;
		int first = s[0] - 'a';
		alpha[first] = 1;

		for (int j = 1; j < s.length(); j++) {
			if (s[j] == s[j - 1])
				continue;
			else {
				int now = s[j] - 'a';
				alpha[now]++;
				if (alpha[now] > 1) {
					isWord = false;
					break;
				}
			}
		}
		if (isWord)
			words++;
		isWord = true;
		fill(alpha, alpha + 26, 0);
	}

	cout << words;
}