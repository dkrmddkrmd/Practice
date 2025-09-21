#include <string>
#include <vector>
#include <algorithm>
#include <cctype>

using namespace std;

int solution(string myString, string pat) {
    int answer = 0;
    
    transform(myString.begin(), myString.end(), myString.begin(), [](char c){return tolower(c);});
    transform(pat.begin(), pat.end(), pat.begin(), [](char c){return tolower(c);});
    
    if(myString.find(pat) != string::npos)
        answer= 1;                                
    
    return answer;
}