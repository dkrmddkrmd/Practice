#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer;
    for(auto query : queries){
        int s = query[0];
        int e = query[1];
        int k = query[2];
        bool first = true;
        bool isNotAns = true;
        int ans;
        
        for(int i = s; i <= e; i++){
            if(arr[i] > k){
                if(first){
                    ans = arr[i];
                    isNotAns = false;            
                    first = false;
                }
                else{
                    if(ans > arr[i])
                        ans = arr[i];
                }
            }
            if(isNotAns)
                ans = -1;
        }
        
        answer.push_back(ans);
    }
    return answer;
}