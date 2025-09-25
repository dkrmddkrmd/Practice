#include <string>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

string solution(string myString) {
    string answer = myString;
    
    transform(answer.begin(), answer.end(), answer.begin(), [](char c){return tolower(c);});
    
    return answer;
}