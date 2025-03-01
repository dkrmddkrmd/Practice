#include <iostream>
#include <string>

using namespace std;

int main() {
	int a;
	cin >> a;

	int find = 0, fountain, sequence;
	// find = +1 +2 +3 +4 -> 1 3 6 10
	// a = cin
	// if a == 5 i = 3 find = 6  fountain = 3 sequence = 2번째 a - find + fountain
	for (int i = 1; ; i++) {
		find += i;
		if (a <= find) {
			fountain = i;
			sequence = a - find + fountain;
			break;
		}
	}

	int baby, mom;
	if (fountain % 2 == 0) {
		baby = 1;
		mom = fountain;
		for (int i = 1; i < sequence; i++) {
			baby++;
			mom--;
		}
	}
	else {
		baby = fountain;
		mom = 1;
		for (int i = 1; i < sequence; i++) {
			baby--;
			mom++;
		}
	}


	cout << baby << "/" << mom;
}