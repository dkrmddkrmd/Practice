#include <iostream>
#include <vector>

using namespace std;

class myStack {
private:
	vector<int> v;

public:
	void order(int n) {
		switch (n)
		{
		case 1: {
			int num;
			cin >> num;
			first(num);
			break;
		}
		case 2: {
			second();
			break;
		}
		case 3: {
			third();
			break;
		}
		case 4: {
			fourth();
			break;
		}
		case 5: {
			fifth();
			break;
		}
		default:
			break;
		}
	}

	private:
		void first(int n) {
			v.push_back(n);
		}
	
		void second() {
			if (v.size() == 0)
				cout << -1 << "\n";
			else
			{
				cout << v[v.size() - 1] << "\n";
				v.pop_back();
			}
		}
	
		void third() {
			cout << v.size() << "\n";
		}
	
		void fourth() {
			if (v.size() == 0)
				cout << 1 << "\n";
			else
				cout << 0 << "\n";
		}
	
		void fifth() {
			if (v.size())
				cout << v[v.size() - 1] << "\n";
			else
				cout << -1 << "\n";
		}
};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	myStack s;
	//s = new myStack();

	while (n--) {
		int num;
		cin >> num;
		s.order(num);
	}

	return 0;
}