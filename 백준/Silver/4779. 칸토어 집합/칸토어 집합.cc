#include <iostream>
#include <vector>

using namespace std;

void kant(vector<string> &v, long long start, long long end) {	
	long long size = end - start + 1;
	if (size < 3)
		return;
	long long third = size / 3;
	for (int i = start + third; i < end - third + 1; i++)
		v[i] = " ";
	kant(v, start, start + third - 1);
	kant(v, end - third + 1, end);
}

int main() {
	int N;
	while (cin >> N) {
		if (N == 0) {
			cout << "-" << "\n";
			continue;
		}
		long long len = 1;
		for (int i = 0; i < N; i++)
			len *= 3;
		vector<string> v(len, "-");
		kant(v, 0, len - 1);
		long long sizes = v.size();
		for (int i = 0; i < sizes; i++)
			cout << v[i];
		cout << "\n";
	}

	return 0;
}