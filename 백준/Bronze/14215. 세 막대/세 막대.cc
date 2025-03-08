#include<algorithm>
#include<cstdlib>
#include<iostream>
#include<string>
#include<cmath>
#include<vector>
#include<numeric>

using namespace std;

int main(void) {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	vector<int> v;
	int a;
	for (int i = 0; i < 3; i++) {
		cin >> a;
		v.push_back(a);
	}

	sort(v.begin(), v.end());
	if (v[2] < v[0] + v[1])
		cout << v[0] + v[1] + v[2];
	else {
		if (v[0] == v[1])
			if (v[0] == 1)
				cout << v[0] * 3;
			else
				cout << v[0] * 3+1;
		else
			cout << (v[0] + v[1])*2-1;
	}

	return 0;
}