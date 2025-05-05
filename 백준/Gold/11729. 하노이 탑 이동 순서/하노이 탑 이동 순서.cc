#include<iostream>
#include<vector>
using namespace std;

vector<int> v1;
vector<int> v2;
vector<int> v3;
vector<int> seq;

void pushToSeq(vector<int>& v) {
	if (&v == &v1)
		seq.push_back(1);
	else if (&v == &v2)
		seq.push_back(2);
	else
		seq.push_back(3);
}

void hanoi(int num, vector<int>& from, vector<int>& to, vector<int>& aux) {
	if (num == 0) return;

	// 1. num-1개 from → aux (by to)
	hanoi(num - 1, from, aux, to);

	// 2. 가장 큰 원판 from → to
	from.pop_back();
	pushToSeq(from);
	to.push_back(num);
	pushToSeq(to);

	// 3. num-1개 aux → to (by from)
	hanoi(num - 1, aux, to, from);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;
	for (int i = N; i > 0; i--)
		v1.push_back(i);

	hanoi(N, v1, v3, v2);

	int nums = (seq.size() + 1) / 2;
	cout << nums << "\n";
	int sizes = seq.size();
	for (int i = 0; i < sizes; i++) {
		cout << seq[i] << " ";
		if (i % 2 == 1)
			cout << "\n";
	}

	return 0;
}
