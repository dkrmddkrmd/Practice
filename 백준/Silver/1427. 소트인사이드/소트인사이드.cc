#include <iostream>
#include <algorithm>

using namespace std;

bool compare(int x, int y) {
	return x < y;
}

int main() {
	long N;
	int ind = 0;
	int arr[10];
	cin >> N;

	for (long i = N; i > 0; i /= 10) {
		long j = i % 10;
		arr[ind++] = j;
	}

	sort(arr, arr + ind, compare);

	for (int i = ind - 1; i >= 0; i--) {
		cout << arr[i];
	}

	return 0;
}