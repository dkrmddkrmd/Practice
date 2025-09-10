#include <string>
#include <vector>

using namespace std;

string solution(string my_string, vector<int> indices) {
    string myAnswer = my_string;
    string answer = "";
    
    for(const auto& i : indices){
        myAnswer[i] = '0';
    }
    
    for(const auto& c : myAnswer){
        if(c != '0')
            answer.push_back(c);
    }
    
    return answer;
}