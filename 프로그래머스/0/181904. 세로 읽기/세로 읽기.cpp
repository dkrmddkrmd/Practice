#include <string>
#include <vector>

using namespace std;

string solution(string my_string, int m, int c) {
    string answer = "";
    int len = my_string.size();
    
    for(int i = 1, j = 1; i <= len; i++, j++){
        
        if(j == c){
            answer.push_back(my_string[i-1]);
        }
        
        if(j == m)
            j = 0; 
    }
    
    return answer;
}