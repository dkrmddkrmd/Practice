#include <string>
#include <vector>

using namespace std;

string solution(string code) {
    string answer = "";
    string myAns = "";
    int len = code.length();
    int mode = 0;
    for(int i = 0; i < len; i++){
        if(mode == 0){
            if(code[i] == '1'){
                mode = 1;
                continue;
            }
            if(i % 2 == 0)
                myAns.push_back(code[i]);
        }
        else{
            if(code[i] == '1'){
                mode = 0;
                continue;
            }
            if(i % 2 == 1)
                myAns.push_back(code[i]);            
        }
    }
    
    if(myAns == "")
        answer = "EMPTY";
    else
        answer = myAns;
    return answer;
}