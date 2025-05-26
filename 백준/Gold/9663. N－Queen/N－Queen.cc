#include <iostream>
// <unordered_map> 더 이상 필요 없음

using namespace std;

// N의 최대값은 15
bool y_occupied[16];       // 열 점유 상태 (1-indexed)
bool diag1_occupied[30];   // 주 대각선 점유 상태, 인덱스: (r - c) + N
bool diag2_occupied[31];   // 부 대각선 점유 상태, 인덱스: r + c
int ans = 0;
int board_size; // N 값을 저장할 변수

void solve(int start_row_candidate, int queens_placed) {
    if (queens_placed == board_size) {
        ans++;
        return;
    }

    // 가지치기: 남은 행의 수가 놓아야 할 퀸의 수보다 적으면 더 진행 불가
    // (board_size - start_row_candidate + 1)는 현재 행부터 마지막 행까지 남은 행의 수
    // (board_size - queens_placed)는 놓아야 할 남은 퀸의 수
    if ((board_size - start_row_candidate + 1) < (board_size - queens_placed)) {
        return;
    }

    for (int r = start_row_candidate; r <= board_size; r++) { // 현재 퀸을 놓을 행 'r'
        for (int c = 1; c <= board_size; c++) {          // 현재 퀸을 놓을 열 'c'
            int d1_idx = (r - c) + board_size; // 주 대각선 인덱스 계산
            int d2_idx = r + c;                // 부 대각선 인덱스 계산

            if (!y_occupied[c] &&
                !diag1_occupied[d1_idx] &&
                !diag2_occupied[d2_idx]) {

                y_occupied[c] = true;
                diag1_occupied[d1_idx] = true;
                diag2_occupied[d2_idx] = true;

                solve(r + 1, queens_placed + 1); // 다음 퀸은 r+1 행부터 탐색

                y_occupied[c] = false;
                diag1_occupied[d1_idx] = false;
                diag2_occupied[d2_idx] = false;
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> board_size;
    solve(1, 0); // 1번 행부터 시작, 놓인 퀸 0개
    cout << ans;

    return 0;
}