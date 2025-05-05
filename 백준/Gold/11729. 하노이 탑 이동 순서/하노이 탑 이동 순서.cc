#include <iostream>
#include <vector>
#include <utility> // std::pair

// 하노이 탑 재귀 함수 (이동 경로를 moves 벡터에 저장)
// (이 함수는 이전과 동일합니다)
void hanoi_store(int n, int source, int destination, int auxiliary, std::vector<std::pair<int, int>>& moves_vec) {
    if (n == 1) {
        moves_vec.push_back({ source, destination });
        return;
    }
    hanoi_store(n - 1, source, auxiliary, destination, moves_vec);
    moves_vec.push_back({ source, destination });
    hanoi_store(n - 1, auxiliary, destination, source, moves_vec);
}

int main() {
    // 입출력 속도 향상 (선택 사항)
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    int n; // 원반의 개수 입력 받기
    std::cin >> n;

    // 1. 이동 경로를 저장할 벡터 생성
    std::vector<std::pair<int, int>> moves_list;

    // 2. 하노이 함수를 먼저 호출하여 이동 경로를 생성하고 벡터에 저장
    hanoi_store(n, 1, 3, 2, moves_list); // 시작: 1, 목표: 3, 보조: 2

    // 3. 생성된 벡터의 크기 (== 총 이동 횟수 K)를 출력
    std::cout << moves_list.size() << "\n";

    // 4. 저장된 이동 경로를 순서대로 출력
    for (const auto& move : moves_list) {
        std::cout << move.first << " " << move.second << "\n";
    }

    return 0; // 프로그램 정상 종료
}