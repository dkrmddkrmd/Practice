#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<int> query) {
    vector<int> answer = arr;
    
    for(int i = 0; i < query.size(); i++){
        if(i % 2 == 0){
            answer.assign(answer.begin(), answer.begin() + query[i] + 1);
        }
        else{
            answer.assign(answer.begin() + query[i], answer.end());
        }
    }
    
    return answer;
}