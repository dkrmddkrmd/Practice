#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, vector<int> slicer, vector<int> num_list) {
    vector<int> answer;
    
    int a = slicer[0];
    int b = slicer[1];
    int c = slicer[2];
    
    // switch문을 사용하면 n값에 따른 구분이 더 명확해집니다.
    switch (n) {
        case 1:
            // num_list의 0번 인덱스부터 b번 인덱스까지
            answer.assign(num_list.begin(), num_list.begin() + b + 1);
            break;
            
        case 2:
            // num_list의 a번 인덱스부터 마지막 인덱스까지
            answer.assign(num_list.begin() + a, num_list.end());
            break;
            
        case 3:
            // num_list의 a번 인덱스부터 b번 인덱스까지
            answer.assign(num_list.begin() + a, num_list.begin() + b + 1);
            break;
            
        case 4:
            // num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로
            // 이 경우는 반복문으로 직접 처리해야 합니다.
            for (int i = a; i <= b; i += c) {
                answer.push_back(num_list[i]);
            }
            break;
    }
    
    return answer;
}