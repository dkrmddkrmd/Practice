#include <iostream>
#include <unordered_map>
#include <vector>
#include <string>
#include <algorithm>
#include <set>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	string s;
	cin >> s;
	set<string> se;

	string st = "";
	for (int i = 0; i < s.length(); i++) {
		for (int j = i; j < s.length(); j++) {
			st += s[j];
			se.insert(st);
		}
		st = "";
	}

	cout << se.size();

	return 0;
}