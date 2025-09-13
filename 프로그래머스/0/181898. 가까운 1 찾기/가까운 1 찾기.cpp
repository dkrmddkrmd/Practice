#include <string>
#include <vector>

using namespace std;

int solution(vector<int> arr, int idx) {
    int answer = 0;
    bool isAnswer = false;
    
    int len = arr.size();
    for(int i = idx; i < len; i++){
        if(arr[i] == 1){
            answer = i;
            isAnswer = true;
            break;
        }
    }
    
    if(!isAnswer)
        answer = -1;
    
    return answer;
}