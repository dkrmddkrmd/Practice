#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <map>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	vector<int> v, bigs;
	map<int, int> m;
	cin >> N;

	int num, sum = 0;

	for (int i = 0; i < N; i++) {
		cin >> num;
		sum += num;
		v.push_back(num);
		if (m.find(num) != m.end())
			m[num] += 1;
		else
			m[num] = 1;
	}

	sort(v.begin(), v.end());

	int size = m.size();
	int big = -1;
	for (auto i : m) {
		if (i.second > big) {
			big = i.second;
			bigs.clear();
			bigs.push_back(i.first);
		}
		else if (i.second == big) {
			bigs.push_back(i.first);
		}
	}

	sort(bigs.begin(), bigs.end());

	int firstAnswer = round((double)sum / N);
	if (firstAnswer == -0)
		firstAnswer = 0;

	int thirdAnswer = bigs.size() == 1 ? bigs[0] : bigs[1];

	cout << firstAnswer << "\n" << v[N / 2] << "\n" << thirdAnswer << "\n" << v[N - 1] - v[0];

	return 0;
}