#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int answer = 0;
    int ans1 = 0, ans2 = 0;
    ans1 += a;
    
    int bLen = b;
    while(bLen){
        ans1 *= 10;
        bLen /= 10;
    }
    ans1 += b;

    ans2 = 2 * a * b;
    
    answer = ans1 > ans2 ? ans1 : ans2;
    return answer;
}