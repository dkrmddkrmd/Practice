#include <string>
#include <vector>

using namespace std;

vector<int> solution(int l, int r) {
    vector<int> answer;
    
    int start = 0;
    for(int i = 5; i <= 1000000; i += 5){
        if(i >= l){
            start = i;
            break;
        }
    }
    
    string s;
    
    for(int i = start; i <= r; i += 5){
        s = to_string(i);
        bool isAns = true;
        for(char c : s){
            if(c != '0' && c != '5'){
                isAns = false;
                break;
            }
        }
        if(!isAns)
            continue;
        
        answer.push_back(i);
    }
    
    if(answer.empty())
        answer.push_back(-1);
    
    return answer;
}