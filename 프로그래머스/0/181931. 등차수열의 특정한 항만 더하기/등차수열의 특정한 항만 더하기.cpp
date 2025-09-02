#include <string>
#include <vector>

using namespace std;

int solution(int a, int d, vector<bool> included) {
    int answer = 0;
    
    int now = a;
    for(auto a : included){
        if(a == true)
            answer += now;
        now += d;
    }
    
    return answer;
}