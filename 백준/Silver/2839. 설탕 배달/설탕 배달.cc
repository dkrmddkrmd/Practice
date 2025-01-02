#include<iostream>
using namespace std;

int main() {
	int N;
	cin >> N;
	int bags = 0;
	int isRight = 0;

	//  24 15  9 
	for (int i = N / 5; i >= 0; i--) {
		bags = 0;
		int leftoverBags = N - (i * 5);
		bags += i;
		int j = leftoverBags / 3;
		if (leftoverBags - (j * 3) == 0) {
			bags += j;
			isRight = 1;
			break;
		}
		else
			continue;
	}

	if (isRight == 0)
		cout << -1;
	else
		cout << bags;

	return 0;
}