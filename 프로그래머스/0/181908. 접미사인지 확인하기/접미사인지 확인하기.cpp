#include <string>
#include <vector>

using namespace std;

int solution(string my_string, string is_suffix) {
    int answer = 0;
    int len = is_suffix.size();
    int slen = my_string.size();
    
    if(len > slen)
        return answer;
        
    if(my_string.substr(slen - len, len) == is_suffix)
        answer = 1;
    
    return answer;
}