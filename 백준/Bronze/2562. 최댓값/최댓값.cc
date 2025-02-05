#include<iostream>

using namespace std;

int main() {
	int arr[9];
	int i = 9;
	int j = 0;
	int max = -1;
	int maxVal = -1;
	while (i--) {
		cin >> arr[j];
		if (arr[j] > max) {
			max = arr[j];
			maxVal = j;
		}
		j++;
	}
	cout << max << "\n" << maxVal + 1;


	return 0;
}