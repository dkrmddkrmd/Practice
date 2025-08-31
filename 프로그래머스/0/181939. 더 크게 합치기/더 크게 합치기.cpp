#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    string s_a = to_string(a);
    string s_b = to_string(b);
    
    string str1 = s_a + s_b;
    string str2 = s_b + s_a;
    
    int ans1 = stoi(str1);
    int ans2 = stoi(str2);
    
    int answer = ans1 > ans2 ? ans1 : ans2;
    
    return answer;
}