#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer = arr;
    for(auto a : queries){
        int s = a[0], e = a[1];
        for(int i = s; i <= e; i++){
            answer[i]++;
        }
    }
    return answer;
}