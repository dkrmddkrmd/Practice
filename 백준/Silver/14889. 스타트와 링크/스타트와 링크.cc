#include <iostream>
#include<vector>

using namespace std;

vector<vector<int>> power;
vector<bool> isTeam;
vector<int> teams;
vector<int> totalPower;
int N;

void dfs(int now, int teamNum) {
    if (teamNum == N / 2) {
        int nowPower = 0;
        for (auto n : teams) {
            for (auto m : teams) {
                nowPower += power[n][m];
            }
        }
        totalPower.push_back(nowPower);
        return;
    }

    for (int i = now; i <= N; i++) {
        if (isTeam[i] == false) {
            isTeam[i] = true;
            teams.push_back(i);
            dfs(i + 1, teamNum + 1);
            teams.pop_back();
            isTeam[i] = false;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;

    power.resize(N + 1);
    for (int i = 1; i <= N; i++) {
        power[i].resize(N + 1);
    }

    isTeam.resize(N + 1, false);

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> power[i][j];
        }
    }

    dfs(1, 0);

    int minNum = 100000000;
    int s = totalPower.size(); // totalPower의 전체 크기를 변수에 저장

    // 0번 인덱스부터 벡터 크기의 절반까지만 반복하면 모든 쌍을 확인할 수 있습니다.
    for (int i = 0; i < s / 2; i++) {
        // i번째 팀과 그에 상응하는 반대편 팀(s - 1 - i)의 능력치 차이를 계산합니다.
        int diff = abs(totalPower[i] - totalPower[s - 1 - i]);
        minNum = min(minNum, diff);
    }

    cout << minNum;

    return 0;
}