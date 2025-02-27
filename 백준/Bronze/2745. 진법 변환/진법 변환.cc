#include<iostream>
#include<algorithm>
#include<cstdlib>
#include<string>

using namespace std;

int main(void) {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	string N;
	int B;

	cin >> N >> B;
	int leng = N.length();
	int total = 0;

	for (int i = leng - 1; i >= 0; i--) {
		if (N[i] >= '0' && N[i] <= '9') {
			int c = N[i] - '0';
			for (int j = leng - i - 1; j > 0; j--) {
				c *= B;
			}
			total += c;
		}
		else {
			int c = N[i] - 'A' + 10;
			for (int j = leng - i - 1; j > 0; j--) {
				c *= B;
			}
			total += c;
		}
	}
	cout << total;

	return 0;
}