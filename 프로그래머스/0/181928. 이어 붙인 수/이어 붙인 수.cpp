#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    string even = "";
    string odd = "";
    
    for(int i : num_list){
        if(i % 2 == 0){
            even += to_string(i);
        }
        else{
            odd += to_string(i);
        }
    }
    answer = stoi(even) + stoi(odd);
    return answer;
}