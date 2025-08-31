#include <string>
#include <vector>

using namespace std;

string solution(string str1, string str2) {
    string answer = "";
    int len = str1.length();
    for(int i = 0; i < len; i++){
        answer.push_back(str1[i]);
        answer.push_back(str2[i]);
    }
    return answer;
}