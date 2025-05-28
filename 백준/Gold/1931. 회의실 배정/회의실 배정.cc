#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Meeting {
    int start_time;
    int end_time;
};

// 정렬을 위한 비교 함수
// 1. 끝나는 시간을 기준으로 오름차순
// 2. 끝나는 시간이 같다면 시작 시간을 기준으로 오름차순
bool compareMeetings(const Meeting& a, const Meeting& b) {
    if (a.end_time == b.end_time) {
        return a.start_time < b.start_time;
    }
    return a.end_time < b.end_time;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<Meeting> meetings(N);
    for (int i = 0; i < N; ++i) {
        cin >> meetings[i].start_time >> meetings[i].end_time;
    }

    // 회의를 끝나는 시간, 그 다음 시작 시간 순으로 정렬
    sort(meetings.begin(), meetings.end(), compareMeetings);

    int count = 0;
    int last_end_time = 0;

    for (int i = 0; i < N; ++i) {
        // 현재 회의의 시작 시간이 이전 회의의 끝나는 시간보다 크거나 같으면 선택
        if (meetings[i].start_time >= last_end_time) {
            last_end_time = meetings[i].end_time;
            count++;
        }
    }

    cout << count << endl;

    return 0;
}