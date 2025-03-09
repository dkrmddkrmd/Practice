#include <iostream>
#include <algorithm>  // sort 함수 사용

using namespace std;

int main() {
    int a, b, c, d;
    cin >> a >> b;
    cin >> c;
    cin >> d;

    if (b >= 0) {
        if (a * d + b > c * d)
            cout << 0;
        else
            cout << 1;
    }
    else {
        if (a > c)
            cout << 0;
        else
            cout << 1;
    }
}
