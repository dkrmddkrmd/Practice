#include<algorithm>
#include<cstdlib>
#include<iostream>
#include<string>

using namespace std;

int main(void) {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int a, b;
	cin >> a >> b;
	int n = 0, t = 0;
	for (int i = 1; i <= a; i++) {
		if (a % i == 0)
			n++;
		if (n == b) {
			cout << i;
			t = 1;
			break;
		}
	}

	if (t == 0)
		cout << 0;


	return 0;
}