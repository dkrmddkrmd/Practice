#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

bool comp(string a, string b) {
    if (a.length() == b.length())
        return a < b;
    else
        return a.length() < b.length();
}

int main() {
    int N;
    cin >> N;
    vector<string> vec(N);

    for (int i = 0; i < N; i++) {
        cin >> vec[i];
    }

    sort(vec.begin(), vec.end(), comp);

    cout << vec[0] << "\n";
    
    for (int i = 1; i < N; i++) {
        if(vec[i] != vec[i-1])
            cout << vec[i] << "\n";
    }
}