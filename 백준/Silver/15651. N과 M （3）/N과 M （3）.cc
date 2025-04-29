#include <iostream>
#include <vector>

#define MAX 7

using namespace std;

int N, M;
vector<int> sequence;

void dfs(int num) {
	if (num == M) {
		for (auto i : sequence) {
			cout << i << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = 1; i <= N; i++) {
		sequence.push_back(i);
		dfs(num + 1);
		sequence.pop_back();
	}
}

int main() {
	cin >> N >> M;
	dfs(0);

	return 0;
}