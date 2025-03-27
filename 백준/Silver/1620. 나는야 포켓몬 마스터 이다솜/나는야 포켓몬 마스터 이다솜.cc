#include <iostream>
#include <unordered_map>  // unordered_map 사용
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    unordered_map<int, string> numToName;  // 숫자로 이름 찾기
    unordered_map<string, int> nameToNum;  // 이름으로 숫자 찾기

    int N, M;
    cin >> N >> M;

    string name;
    for (int i = 1; i <= N; i++) {
        cin >> name;
        numToName[i] = name;
        nameToNum[name] = i;
    }

    for (int i = 0; i < M; i++) {
        cin >> name;
        if (isdigit(name[0])) {  // 숫자인 경우
            int n = stoi(name);
            cout << numToName[n] << "\n";
        } else {  // 이름인 경우
            cout << nameToNum[name] << "\n";
        }
    }
}