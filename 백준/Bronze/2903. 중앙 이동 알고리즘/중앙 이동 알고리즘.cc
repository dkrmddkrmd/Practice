#include <iostream>
#include <string>

using namespace std;

int main() {

	int N, sq = 1;
	cin >> N;
	

	for (int i = 0; i < N; i++) {
		sq *= 2;
	}

	cout << (sq + 1) * (sq + 1);
}