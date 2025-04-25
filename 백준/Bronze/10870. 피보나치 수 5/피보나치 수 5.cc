#include <iostream>

using namespace std;

long long myFac(int N) {
    if (N == 0)
        return 0;

    if (N == 1)
        return 1;

    return myFac(N - 2) + myFac(N - 1);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    cout << myFac(N);

    return 0;
}