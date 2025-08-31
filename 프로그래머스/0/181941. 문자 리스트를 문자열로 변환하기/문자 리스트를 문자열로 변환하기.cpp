#include <string>
#include <vector>

using namespace std;

string solution(vector<string> arr) {
    string answer = "";
    for(int i = 0; i < arr.size(); i++)
        answer.push_back(arr[i][0]);
    return answer;
}