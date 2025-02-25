#include<iostream>
#include<algorithm>
#include<cstdlib>
#include<string>

using namespace std;

int main(void) {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int max = -1;
	int a;
	int row, col;

	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cin >> a;
			if (a >= max) {
				max = a;
				row = i;
				col = j;
			}
		}
	}

	cout << max << "\n" << row+1 << " " << col+1;

	return 0;
}