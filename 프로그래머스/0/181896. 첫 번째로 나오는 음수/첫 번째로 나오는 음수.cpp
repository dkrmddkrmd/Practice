#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    bool ans = false;
    for(int i = 0; i < num_list.size(); i++){
        if(num_list[i] < 0){
            ans = true;
            answer = i;
            break;
        }
    }
    if(!ans)
        answer = -1;
    
    return answer;
}