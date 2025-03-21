#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

bool comp(pair<int, string> a, pair<int, string> b) {
	return a.first < b.first;
}

int main() {
	int N;
	cin >> N;

	vector<pair<int, string>> vec(N);
	int age;
	string name;
	for (int i = 0; i < N; i++) {
		cin >> age >> name;
		vec[i] = { age, name };
	}

	stable_sort(vec.begin(), vec.end(), comp);

	for (int i = 0; i < N; i++) {
		cout << vec[i].first << " " << vec[i].second << "\n";
	}
}