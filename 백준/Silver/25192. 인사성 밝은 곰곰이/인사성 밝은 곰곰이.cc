#include <iostream>
#include <set>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	set<string> us;
	cin >> N;

	int imo = 0;
	string s;
	while (N--) {
		cin >> s;
		if (s == "ENTER") {
			us.clear();
		}
		else {
			if (us.find(s) == us.end()) {
				imo++;
				us.insert(s);
			}
		}
	}
	cout << imo;

	return 0;
}