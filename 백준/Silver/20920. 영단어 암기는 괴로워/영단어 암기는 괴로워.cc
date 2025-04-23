#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

// 정렬 기준 함수
bool myCompare(const pair<string, int>& a, const pair<string, int>& b) {
    if (a.second != b.second)
        return a.second > b.second; // 자주 등장하는 단어 우선
    if (a.first.size() != b.first.size())
        return a.first.size() > b.first.size(); // 길이 긴 단어 우선
    return a.first < b.first; // 사전순 정렬
}

int main() {
    int N, M;
    cin >> N >> M;

    map<string, int> m;
    string s;

    for (int i = 0; i < N; i++) {
        cin >> s;
        if (s.size() < M)
            continue;
        m[s]++;
    }

    // map -> vector로 복사
    vector<pair<string, int>> v(m.begin(), m.end());

    // 사용자 정의 정렬
    sort(v.begin(), v.end(), myCompare);

    for (auto& p : v) {
        cout << p.first << "\n";
    }

    return 0;
}