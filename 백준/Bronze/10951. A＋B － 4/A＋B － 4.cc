#include <iostream>

using namespace std;

int main() {
    int a, b;
    
    // 입력이 정상적으로 들어오는 동안 반복
    while (cin >> a >> b) {
        cout << a + b << "\n";
    }

    return 0;
}