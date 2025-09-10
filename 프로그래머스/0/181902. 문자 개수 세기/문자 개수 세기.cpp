#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(string my_string) {
    vector<int> answer(52, 0);
    
    int len = my_string.size();
    
    for(int i = 0; i < len; i++){
        if(my_string[i] - 0 >= 65 && my_string[i] - 0 <= 90){
            answer[my_string[i] - 65]++;
        }
        else{
            answer[my_string[i] - 97 + 26]++;
        }
    }
    
    return answer;
}