#include <string>
#include <vector>

using namespace std;

int solution(vector<int> arr) {
    int answer = 0;
    
    bool isSame;
    
    while(true){
        isSame = true;
        answer++;
        for(auto &a : arr){
            if(a >= 50 && a % 2 == 0){
                a /= 2;
                isSame = false;
            }
            else if(a < 50 && a % 2 == 1){
                a = a*2 + 1;
                isSame = false;
            }
      }
        if(isSame)
            break;
    }

    
    return answer - 1;
}