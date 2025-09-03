#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer = arr;
    
    for(const auto& a : queries){
        int s = a[0];
        int e = a[1];
        int k = a[2];
        
        for(int i = s; i <= e; i++){
            if(i % k == 0)
                answer[i]++;
        }
    }
    
    return answer;
}