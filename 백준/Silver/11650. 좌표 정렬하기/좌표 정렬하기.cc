#include <iostream>
#include <string>
#include <algorithm>
#include<vector>

using namespace std;

int main() {
    int N;
    int a, b;
    cin >> N;
    vector < pair<int, int>> v;
    for (int i = 0; i < N; i++) {
        cin >> a >> b;
        v.push_back({ a, b });
    }

    sort(v.begin(), v.end());

    for (int i = 0; i < N; i++) {
        cout << v[i].first << " " << v[i].second << "\n";
    }
}