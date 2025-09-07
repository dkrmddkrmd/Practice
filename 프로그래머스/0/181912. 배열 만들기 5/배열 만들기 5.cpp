#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> intStrs, int k, int s, int l) {
    vector<int> answer;
    
    for(auto a : intStrs){
        string nowStr = a.substr(s, l);
        int nowAns = stoi(nowStr);
        if(nowAns > k)
            answer.push_back(nowAns);
    }
    
    return answer;
}