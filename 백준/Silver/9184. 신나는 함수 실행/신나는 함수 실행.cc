#include <iostream>
#include <vector> // dp 테이블을 vector로 만들 경우 필요, 여기선 전역 배열 사용

// dp[a][b][c]는 w(a, b, c)의 값을 저장합니다.
// 유효 인덱스는 0부터 20까지이므로 크기는 21x21x21
// 문제에서 w(a,b,c)의 결과는 항상 1 이상이므로, 0을 '아직 계산 안됨'으로 사용 가능
int dp[21][21][21];

int w_recursive_memo(int a, int b, int c) {
    // 기본 케이스 1: a, b, c 중 하나라도 0 이하이면 1 반환
    if (a <= 0 || b <= 0 || c <= 0) {
        return 1;
    }

    // 기본 케이스 2: a, b, c 중 하나라도 20 초과이면 w(20, 20, 20) 호출
    // 이 경우, 인자를 20으로 고정하여 재호출하므로, dp 배열 접근 시 인덱스 초과 방지
    if (a > 20 || b > 20 || c > 20) {
        return w_recursive_memo(20, 20, 20);
    }

    // 메모이제이션 확인: 이미 계산된 값이면 dp 배열에서 가져와 반환
    // dp[a][b][c]가 0이 아니라면 이미 계산된 것 (결과가 항상 1 이상이므로)
    if (dp[a][b][c] != 0) {
        return dp[a][b][c];
    }

    // 재귀 케이스 계산 및 dp 배열에 저장
    if (a < b && b < c) {
        dp[a][b][c] = w_recursive_memo(a, b, c - 1) +
                      w_recursive_memo(a, b - 1, c - 1) -
                      w_recursive_memo(a, b - 1, c);
    } else {
        dp[a][b][c] = w_recursive_memo(a - 1, b, c) +
                      w_recursive_memo(a - 1, b - 1, c) +
                      w_recursive_memo(a - 1, b, c - 1) -
                      w_recursive_memo(a - 1, b - 1, c - 1);
    }

    return dp[a][b][c];
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    int a, b, c;
    while (std::cin >> a >> b >> c) {
        if (a == -1 && b == -1 && c == -1) {
            break;
        }

        // dp 배열은 각 테스트 케이스마다 초기화할 필요가 없습니다.
        // w_recursive_memo 함수가 (0,0,0) 부터 (20,20,20) 범위 내의 값들을
        // 한 번 계산하면 그 값은 변하지 않기 때문입니다.
        // 전역 변수 dp는 프로그램 시작 시 0으로 자동 초기화됩니다.

        int result = w_recursive_memo(a, b, c);
        std::cout << "w(" << a << ", " << b << ", " << c << ") = " << result << "\n";
    }

    return 0;
}