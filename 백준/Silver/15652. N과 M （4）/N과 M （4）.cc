#include <iostream>
#include <vector>

#define MAX 7

using namespace std;

int N, M;
vector<int> sequence;

void dfs(int num, int start) {
	if (num == M) {
		for (auto i : sequence) {
			cout << i << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = start; i <= N; i++) {
		sequence.push_back(i);
		dfs(num + 1, i);
		sequence.pop_back();
	}
}

int main() {
	cin >> N >> M;
	dfs(0, 1);

	return 0;
}