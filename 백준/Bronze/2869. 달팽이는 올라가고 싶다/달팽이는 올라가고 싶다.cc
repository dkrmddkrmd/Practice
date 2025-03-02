#include <iostream>
#include <string>

using namespace std;

int main() {
	long long a, b, v, yesterday;
	cin >> a >> b >> v;

	// 18 4 4 4 4 5 -> 5일
	
	if ((v - a) % (a - b) == 0)
		yesterday = (v - a) / (a - b);
	else
		yesterday = ((v - a) / (a - b)) + 1;

	cout << yesterday + 1;
	
}