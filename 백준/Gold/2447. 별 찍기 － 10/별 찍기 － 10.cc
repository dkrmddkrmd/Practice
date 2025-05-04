#include <iostream>
#include <vector>
#include <string> // string 헤더 포함

using namespace std;

// (x, y)는 현재 처리할 사각형의 왼쪽 위 좌표
// num은 현재 처리할 사각형의 한 변의 길이
void star(vector<vector<string>>& v, int x, int y, int num) {
	// num이 1이면 더 이상 나눌 수 없으므로 종료 (기저 사례)
	if (num == 1) {
		return;
	}

	// 현재 사각형을 9등분했을 때 작은 사각형의 한 변의 길이
	int newNum = num / 3;

	// 9개의 작은 사각형 영역을 순회
	for (int j_offset = 0; j_offset < 3; ++j_offset) {
		for (int i_offset = 0; i_offset < 3; ++i_offset) {
			// 가운데 사각형(j_offset == 1 && i_offset == 1)일 경우
			if (i_offset == 1 && j_offset == 1) {
				// 해당 영역을 공백으로 채움
				for (int j = y + newNum; j < y + 2 * newNum; ++j) {
					for (int i = x + newNum; i < x + 2 * newNum; ++i) {
						v[j][i] = " "; // 행 인덱스 j, 열 인덱스 i
					}
				}
			}
			else {
				// 가운데가 아닌 8개의 사각형에 대해서는 재귀 호출
				// 다음 재귀 호출의 시작 좌표와 크기(newNum)를 전달
				star(v, x + i_offset * newNum, y + j_offset * newNum, newNum);
			}
		}
	}
}

int main() {
	// 입출력 속도 향상 (선택 사항)
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	// N x N 크기의 2차원 벡터를 "*"로 초기화
	// v[행][열] 순서로 접근
	vector<vector<string>> v(N, vector<string>(N, "*"));

	// 재귀 함수 시작: 전체 영역 (0, 0)에서 시작하고 크기는 N
	star(v, 0, 0, N);

	// 결과 출력
	// 바깥쪽 루프가 행(j), 안쪽 루프가 열(i)을 담당
	for (int j = 0; j < N; j++) { // 행 반복
		for (int i = 0; i < N; i++) { // 열 반복
			cout << v[j][i]; // v[행][열] 순서로 출력
		}
		cout << "\n";
	}

	return 0;
}