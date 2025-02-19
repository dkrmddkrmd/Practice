#include<iostream>
#include<algorithm>
#include<cstdlib>
#include<string>

using namespace std;

int main(void) {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	string a;
	cin >> a;
	int b = a.length();
	for (int i = 0; i < b; i++)
		a[i] = tolower(a[i]);

	int arr[26];
	for (int i = 0; i < 26; i++)
		arr[i] = 0;

	for (int i = 0; i < b; i++) {
		int c = a[i] - 97;
		arr[c]++;
	}

	int max = -1;
	int charac = 0;
	int count = -1;

	for (int i = 0; i < 26; i++) {
		if (arr[i] > max) {
			max = arr[i];
			count = 0;
			charac = i;
		}
		else if (arr[i] == max) {
			count++;
		}
	}

	if (count == 0) {
		char d = 'a' + charac;
		d = toupper(d);
		cout << d;
	}
	else
		cout << "?";

	return 0;
}