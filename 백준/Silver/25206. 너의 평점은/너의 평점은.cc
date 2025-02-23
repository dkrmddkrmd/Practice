#include<iostream>
#include<algorithm>
#include<cstdlib>
#include<string>

using namespace std;

int main(void) {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	string lec, gra;
	double num;
	double total = 0, granum = 0;

	int a = 20;
	while (a--) {
		cin >> lec >> num >> gra;
		if (gra == "A+") {
			total += num * 4.5;
			granum += num;
		}
		else if (gra == "A0") {
			total += num * 4.0;
			granum += num;
		}
		else if (gra == "B+") {
			total += num * 3.5;
			granum += num;
		}
		else if (gra == "B0") {
			total += num * 3.0;
			granum += num;
		}
		else if (gra == "C+") {
			total += num * 2.5;
			granum += num;
		}
		else if (gra == "C0") {
			total += num * 2.0;
			granum += num;
		}
		else if (gra == "D+") {
			total += num * 1.5;
			granum += num;
		}
		else if (gra == "D0") {
			total += num * 1.0;
			granum += num;
		}
		else if (gra == "F") {
			granum += num;
		}
		else
			continue;
	}

	cout << total / granum;

	return 0;
}