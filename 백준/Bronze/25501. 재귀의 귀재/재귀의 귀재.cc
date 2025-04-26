#include<iostream>

using namespace std;

int nums = 1;

int recursion(const string& s, int l, int r) {
    if (l >= r) return 1;
    else if (s[l] != s[r]) return 0;
    else {
        nums++;
        return recursion(s, l + 1, r - 1);
    }
}

int isPalindrome(const string& s) {
    nums = 1;
    return recursion(s, 0, s.size() - 1);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    string str;
    for (int i = 0; i < T; i++) {
        cin >> str;
        
        int myNum = isPalindrome(str);
        cout << myNum << " " << nums << "\n";
    }
}