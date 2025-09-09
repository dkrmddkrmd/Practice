#include <string>
#include <vector>

using namespace std;

string solution(string my_string, int s, int e) {
    string answer = my_string;
    for(int i = e , j = s ; i >= s ; i--, j++){
        answer[j] = my_string[i];
    }
    return answer;
}