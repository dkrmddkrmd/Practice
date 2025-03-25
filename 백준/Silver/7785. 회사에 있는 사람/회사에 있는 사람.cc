#include <iostream>
#include <map>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    map<string, string, greater<>> m;

    string name, state;
    for (int i = 0; i < N; i++) {
        cin >> name >> state;
        m[name] = state;
    }

    for (const auto& a : m) {
        if (a.second == "enter")
            cout << a.first << "\n";
    }

    return 0;
}