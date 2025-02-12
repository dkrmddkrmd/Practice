#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main() {
	string a, b;
	cin >> a >> b;
	reverse(a.begin(), a.end());
	reverse(b.begin(), b.end());
	int c, d;
	c = stoi(a);
	d = stoi(b);

	if (a >= b)
		cout << c;
	else
		cout << d;

	return 0;
}