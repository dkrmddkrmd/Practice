#include<iostream>
#include<vector>

using namespace std;

int N, maxVal, minVal;
vector<int> nums; // 숫자 배열, 변하지 않음 ex) 1 2 3 4 5 6
vector<int> ops; // 연산자 배열 ex) 1 1 2 3 4
vector<int> ops_per; // 연산자 순열  ex) 1 2 3 4 5, 1 2 3 5 4, .....
vector<bool> ops_b; // 연산자 방문 확인
bool isFirst = true;

void dfs(int depth) {
	if (depth == N - 1) {
		int nowVal = nums[0];
		for (int i = 0; i < N - 1; i++) {
			switch (ops[ops_per[i]]) {
			case 1:
				nowVal += nums[i + 1];
				break;
			case 2:
				nowVal -= nums[i + 1];
				break;
			case 3:
				nowVal *= nums[i + 1];
				break;
			case 4:
				nowVal /= nums[i + 1];
				break;
			default:
				return;
			}
		}

		if (isFirst) {
			isFirst = false;
			maxVal = nowVal;
			minVal = nowVal;
		}
		else {
			maxVal = max(nowVal, maxVal);
			minVal = min(nowVal, minVal);
		}
	}

	for (int i = 0; i < N - 1; i++) {
		if (ops_b[i] == false) {
			ops_b[i] = true;
			ops_per.push_back(i);
			dfs(depth + 1);
			ops_per.pop_back();
			ops_b[i] = false;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

	nums.resize(N);
	ops_b.resize(N-1, false);
	int num;
	for (int i = 0; i < N; i++) {
		cin >> num;
		nums[i] = num;
	}

	cin >> num;
	ops.insert(ops.end(), num, 1);

	cin >> num;
	ops.insert(ops.end(), num, 2);

	cin >> num;
	ops.insert(ops.end(), num, 3);

	cin >> num;
	ops.insert(ops.end(), num, 4);

	dfs(0);

	cout << maxVal << "\n" << minVal;

	return 0;
}