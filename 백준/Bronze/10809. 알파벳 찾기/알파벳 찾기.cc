#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main() {
	string a;
	int b[26];
	fill(b, b + 26, -1);

	cin >> a;

	for (int i = 0; i < a.length(); i++) {
		int j = a[i] - 'a';
		if (b[j] == -1)
			b[j] = i;
	}

	for (int i : b)
		cout << i << " ";

	return 0;
}