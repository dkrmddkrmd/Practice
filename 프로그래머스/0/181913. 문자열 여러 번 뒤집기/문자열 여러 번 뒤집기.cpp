#include <string>
#include <vector>

using namespace std;

string solution(string my_string, vector<vector<int>> queries) {
    string answer = my_string;
    
    for(auto a : queries){
        
        for(int first = a[0], last = a[1]; first < last; first++, last--){
            char temp = answer[first];
            answer[first] = answer[last];
            answer[last] = temp;
        }
    }
    
    return answer;
}