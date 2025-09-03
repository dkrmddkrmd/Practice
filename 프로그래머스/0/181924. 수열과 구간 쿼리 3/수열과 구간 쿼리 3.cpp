#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer = arr;
    
    for(const auto& a : queries){
        int first = a[0];
        int second = a[1];
        
        int temp = answer[first];
        answer[first] = answer[second];
        answer[second] = temp;
    }
    
    return answer;
}