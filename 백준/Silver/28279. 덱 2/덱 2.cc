#include <iostream>
#include <deque>

using namespace std;

class myDeq {
private:
	deque<int> d;

	void one(int x) {
		d.push_front(x);
	}
	void two(int x) {
		d.push_back(x);
	}
	void three() {
		if (!d.empty()) {
			cout << d.front() << "\n";
			d.pop_front();
		}
		else
			cout << "-1\n";
	}
	void four() {
		if (!d.empty()) {
			cout << d.back() << "\n";
			d.pop_back();
		}
		else
			cout << "-1\n";
	}
	void five() {
		cout << d.size() << "\n";
	}
	void six() {
		if (d.empty())
			cout << "1\n";
		else
			cout << "0\n";
	}
	void seven() {
		if (!d.empty()) {
			cout << d.front() << "\n";
		}
		else
			cout << "-1\n";
	}
	
	void eight() {
		if (!d.empty()) {
			cout << d.back() << "\n";
		}
		else
			cout << "-1\n";
	}
public:
	void order(int n) {
		switch (n)
		{
		case 1: {
			int m;
			cin >> m;
			one(m);
			break;
		}
		case 2: {
			int m;
			cin >> m;
			two(m);
			break;
		}
		case 3:
			three();
			break;
		case 4:
			four();
			break;
		case 5:
			five();
			break;
		case 6:
			six();
			break;
		case 7:
			seven();
			break;
		case 8:
			eight();
			break;
		default:
			break;
		}
	}

};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	myDeq m;
	int N;
	cin >> N;
	while (N--) {
		int n;
		cin >> n;
		m.order(n);
	}

	return 0;
}