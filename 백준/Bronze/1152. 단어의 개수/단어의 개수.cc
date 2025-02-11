#include<iostream>
#include<algorithm>
#include<cstdlib>
#include<string>

using namespace std;

int main(void) {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	string a;
	getline(cin, a);
	int n = 0;
	bool k = true;

	int b = a.length();

	for (int i = 0; i < b; i++) {
		if (a[i] == ' ')
			k = true;
		else if (k == true) {
			k = false;
			n++;
		}
	}

	cout << n;

	return 0;
	}