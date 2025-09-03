#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    vector<int> answer = num_list;
    int len = answer.size();
    
    //num_list의 길이는 2 이상이므로
    if(num_list[len-1] > num_list[len-2]){
        answer.push_back(answer[len-1] - num_list[len-2]);
    }
    else{
        answer.push_back(num_list[len-1] * 2);
    }
    return answer;
}