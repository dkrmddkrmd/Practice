#include <iostream>
#include <cmath>
using namespace std;
typedef long long ll;

bool IsSosu(ll n)
{
	if (n < 2) return false;
	int sqrtN = sqrt(n);
	for (ll i = 2; i <= sqrtN ; i++)
		if (n % i == 0) return false;
	return true;
}

int main()
{
	cin.tie(0);
	cout.tie(0);
	ios::sync_with_stdio(0);

	int tk;
	cin >> tk;
	for (int t = 0; t < tk; t++) {
		ll n;
		cin >> n;
		while (!IsSosu(n)) {
			n++;
		}
		cout << n << '\n';
	}
}