#include <string>
#include <vector>

using namespace std;

string solution(string my_string, string overwrite_string, int s) {
    string answer = "";
    
    int len = overwrite_string.length();
    
    for(int i = s, j = 0; j < len && i < my_string.length(); i++, j++){
        my_string[i] = overwrite_string[j];
    }
    
    answer = my_string;
        
    return answer;
}