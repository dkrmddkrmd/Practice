#include<iostream>
#include<algorithm>
#include<cstdlib>
#include<string>

using namespace std;

int main(void) {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	char words[5][16] = { 0 };
	int max = -1;

	for (int i = 0; i < 5; i++) {
		cin >> words[i];
	}

	for (int i = 0; i < 15; i++) {
		for (int j = 0; j < 5; j++) {
			if (words[j][i] >= 'a' && words[j][i] <= 'z')
				cout << words[j][i];
			else if (words[j][i] >= 'A' && words[j][i] <= 'Z')
				cout << words[j][i];
			else if (words[j][i] >= '0' && words[j][i] <= '9')
				cout << words[j][i];
			else
				continue;
		}
	}

	return 0;
}