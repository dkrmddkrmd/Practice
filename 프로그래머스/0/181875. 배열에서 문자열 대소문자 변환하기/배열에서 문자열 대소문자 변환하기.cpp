#include <string>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

vector<string> solution(vector<string> strArr) {
    vector<string> answer = strArr;
    
    int len = strArr.size();
    
    for(int i = 0; i < len; i++){
        if(i % 2 == 1){
            transform(answer[i].begin(), answer[i].end(), answer[i].begin(), [](char c){return toupper(c);});
        }
        else{
            transform(answer[i].begin(), answer[i].end(), answer[i].begin(), [](char c){return tolower(c);});
        }
    }
    
    return answer;
}