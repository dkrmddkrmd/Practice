#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list, int n) {
    vector<int> answer(num_list.begin() + n, num_list.end());
    
    for(int i = 0; i < n; i++)
        answer.push_back(num_list[i]);
    
    return answer;
}