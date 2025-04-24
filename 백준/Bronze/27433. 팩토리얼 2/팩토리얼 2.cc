#include <iostream>

using namespace std;

long long myFac(int N) {
    if (N == 1 || N == 0)
        return 1;

    long long myNum = N * myFac(N - 1);
    return myNum;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    cout << myFac(N);

    return 0;
}