#include <string>
#include <vector>

using namespace std;

string solution(string myString) {
    string answer = myString;
    
    for(char &c : answer){
        if(c == 'a' || c == 'A'){
            c = 'A';
        }
        else{
            if(c >= 'A' && c <= 'Z'){
                c += 'a' - 'A';
            }
        }
    }
    
    return answer;
}