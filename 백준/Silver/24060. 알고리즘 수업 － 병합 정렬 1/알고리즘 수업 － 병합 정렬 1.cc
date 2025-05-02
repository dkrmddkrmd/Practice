#include <iostream>
#include <vector>

using namespace std;

int N, K;
int num = 0;
bool found = false;

void merge_sort(vector<int>& A, int p, int r);
void merge(vector<int>& A, int p, int q, int r);

void merge_sort(vector<int>& A, int p, int r) {
    if (p < r) {
        int q = (p + r) / 2;
        merge_sort(A, p, q);
        merge_sort(A, q + 1, r);
        merge(A, p, q, r);
    }
}

void merge(vector<int>& A, int p, int q, int r) {
    int i = p;
    int j = q + 1;
    vector<int> tmp;

    while (i <= q && j <= r) {
        if (A[i] <= A[j]) {
            tmp.push_back(A[i++]);
        }
        else {
            tmp.push_back(A[j++]);
        }
        num++;
        if (num == K) {
            cout << tmp.back();  // 방금 넣은 값 출력
            found = true;
            return;
        }
    }

    while (i <= q) {
        tmp.push_back(A[i++]);
        num++;
        if (num == K) {
            cout << tmp.back();
            found = true;
            return;
        }
    }

    while (j <= r) {
        tmp.push_back(A[j++]);
        num++;
        if (num == K) {
            cout << tmp.back();
            found = true;
            return;
        }
    }

    for (int k = 0; k < tmp.size(); k++) {
        A[p + k] = tmp[k];
    }
}

int main() {
    cin >> N >> K;
    vector<int> A(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }

    merge_sort(A, 0, N - 1);

    if (!found)
        cout << -1;

    return 0;
}
