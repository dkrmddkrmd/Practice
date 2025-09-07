#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> solution(string my_string) {
    vector<string> answer;
    
    int len = my_string.size();
    for(int i = 0,j = len ; i < len; i++, j--){
        answer.push_back(my_string.substr(i, j));
    }
    
    sort(answer.begin(), answer.end());
    
    return answer;
}