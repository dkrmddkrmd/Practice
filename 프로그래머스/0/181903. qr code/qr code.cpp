#include <string>
#include <vector>

using namespace std;

string solution(int q, int r, string code) {
    string answer = "";
    
    int len = code.size();
    
    for(int i = r; i < len; i += q)
        answer.push_back(code[i]);
    
    
    return answer;
}