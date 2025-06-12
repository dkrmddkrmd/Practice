#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;

vector<vector<int>> board;
vector<int> houses;
int sequence = 2;
int nowHouse = 0;

void solve(int x, int y, int size) {
	// 상하좌우 확인하고 1이면 같은 걸로 취급하고 그 다음 애들도 넓혀감
	// 상
	if (x > 0) {
		if (board[x - 1][y] == 1) {
			nowHouse++;
			board[x - 1][y] = sequence;
			solve(x - 1, y, size);
		}
	}
	// 하
	if (x < size - 1) {
		if (board[x + 1][y] == 1) {
			nowHouse++;
			board[x + 1][y] = sequence;
			solve(x + 1, y, size);
		}
	}
	// 좌
	if (y > 0) {
		if (board[x][y - 1] == 1) {
			nowHouse++;
			board[x][y - 1] = sequence;
			solve(x, y - 1, size);
		}
	}
	// 우
	if (y < size - 1) {
		if (board[x][y + 1] == 1) {
			nowHouse++;
			board[x][y + 1] = sequence;
			solve(x, y + 1, size);
		}
	}
}

int main() {
	int N;
	cin >> N;
	board.resize(N, (vector<int>(N)));

	string s;
	for (int i = 0; i < N; i++) {
		cin >> s;
		for (int j = 0; j < N; j++) {
			board[i][j] = s[j] - '0';
		}
	}

	// ... main 함수 내부 ...
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			// 1. 새로운 단지를 발견하면!
			if (board[i][j] == 1) {
				// 2. 여기서 집 개수 세기를 '새로' 시작해야 함
				nowHouse = 1; // 자기 자신을 포함하여 1로 시작
				board[i][j] = sequence;

				// 3. 이 단지에 연결된 모든 집을 탐색
				solve(i, j, N);

				// 4. '하나'의 단지 탐색이 끝났으므로 '즉시' 결과를 저장
				houses.push_back(nowHouse);

				// 5. 다음 단지를 위해 초기화 및 시퀀스 증가
				nowHouse = 0;
				sequence++;
			}
		}
	}
	// 이 바깥의 if문은 이제 필요 없음!
	// if (nowHouse != 0) { ... }

	sort(houses.begin(), houses.end());

	cout << houses.size() << "\n";
	for (auto n : houses)
		cout << n << "\n";

	return 0;
} 