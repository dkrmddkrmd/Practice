#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    int mul = 1, plu = 0;
    for(int i : num_list){
        mul *= i;
        plu += i;
    }
    plu *= plu;
    answer = mul > plu ? 0 : 1;
    return answer;
}