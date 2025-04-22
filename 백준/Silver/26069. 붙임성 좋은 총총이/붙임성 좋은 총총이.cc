#include <iostream>
#include <set>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	set<string> mySet;
	cin >> N;

	string s1, s2;

	mySet.insert("ChongChong");

	while (N--) {
		cin >> s1 >> s2;
		if (s1 == "ChongChong") {
			mySet.insert(s2);
			continue;
		}

		if (s2 == "ChongChong") {
			mySet.insert(s1);
			continue;
		}

		if (mySet.find(s1) != mySet.end()) {
			mySet.insert(s2);
			continue;
		}

		if (mySet.find(s2) != mySet.end()) {
			mySet.insert(s1);
			continue;
		}
	}

	cout << mySet.size();

	return 0;
}