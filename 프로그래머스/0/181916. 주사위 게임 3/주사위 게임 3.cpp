#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int a, int b, int c, int d) {
    int answer = 0;
    if(a == b && b == c && c == d){
        answer = 1111 * a;
    }
    else if(a == b && b == c && c != d){
        answer = (10 * a + d)*(10 * a + d);
    }
    else if(a == b && b == d && c != d){
        answer = (10 * a + c)*(10 * a + c);
    }
    else if(a == c && d == c && c != b){
        answer = (10 * a + b)*(10 * a + b);
    }
    else if(d == b && b == c && c != a){
        answer = (10 * b + a)*(10 * b + a);
    }
    else if(a == b && c == d && a != c){
        answer = (a + c) * abs(a - c);
    }
    else if(a == c && b == d && a != b){
        answer = (a + b) * abs(a - b);
    }
    else if(a == d && c == b && a != c){
        answer = (a + c) * abs(a - c);
    }
    else if(a == b && b != c && b != d){
        answer = c * d;
    }
    else if(a == c && c != b && c != d){
        answer = b * d;
    }
    else if(a == d && a != b && a != c){
        answer = b * c;
    }
    else if(b == c && b != a && b != d){
        answer = a * d;
    }
    else if(b == d && b != c && b != a){
        answer = a * c;
    }
    else if(c == d && c != a && c != b){
        answer = a * b;
    }
    else if(a != b && b != c && c != d){
        answer = min(a, min(b, min(c, d)));
    }
    
    
    return answer;
}