#include<iostream>
#include<algorithm>
#include<cstdlib>

using namespace std;
int arr[25];

int main(void) {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int a, c;
	char b;
	int sum = 0;
	cin >> a;
	while (a--) {
		cin >> b;
		c = b - '0';
		sum += c;
	}

	cout << sum;

	return 0;
	}