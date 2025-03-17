#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

bool compare(int a, int b) {
	return a > b;
}

int main() {
	int N, k;
	cin >> N >> k;
	vector<int> vec(N);

	for (int i = 0; i < N; i++) {
		cin >> vec[i];
	}

	sort(vec.begin(), vec.end(), compare);
	cout << vec[k - 1];

}