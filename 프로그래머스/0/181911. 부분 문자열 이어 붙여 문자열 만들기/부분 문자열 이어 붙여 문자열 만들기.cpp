#include <string>
#include <vector>

using namespace std;

string solution(vector<string> my_strings, vector<vector<int>> parts) {
    string answer = "";
    
    int i = 0;
    for(auto a : parts){
        int s = a[0];
        int e = a[1];
        
        string nowStr = my_strings[i].substr(s, e-s+1);
        answer += nowStr;
        i++;
    }
    
    return answer;
}