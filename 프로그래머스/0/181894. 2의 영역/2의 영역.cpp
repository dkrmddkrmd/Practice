#include <string>
#include <vector>
#include <limits>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    vector<int> ind;
    int fir = -1, sec;
    
    for(int i = 0; i < arr.size(); i++){
        if(arr[i] == 2){
            fir = i;
            break;
        }
    }
    
    if(fir == -1){
        answer.push_back(-1);
        return answer;
    }
    
    for(int i = arr.size() - 1; i >= 0; i--){
        if(arr[i] == 2){
            sec = i;
            break;
        }
    }
    
    answer.assign(arr.begin() + fir, arr.begin() + sec + 1);
    
    return answer;
}