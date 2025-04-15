#include <iostream>
#include <string>
#include <deque>

using namespace std;

enum class myOrders {
	push,
	pop,
	size,
	empty,
	front,
	back,
	Invalid
};

class myStack {
private:
	deque<int> d;

	void push(int num) {
		d.push_back(num);
	}

	void pop() {
		if (d.empty())
			cout << -1 << "\n";
		else {
			cout << d.front() << "\n";
			d.pop_front();
		}
	}

	void size() {
		cout << d.size() << "\n";
	}

	void empty() {
		if (d.empty())
			cout << 1 << "\n";
		else
			cout << 0 << "\n";
	}

	void front() {
		if (d.empty())
			cout << -1 << "\n";
		else
			cout << d.front() << "\n";
	}

	void back() {
		if (d.empty())
			cout << -1 << "\n";
		else
			cout << d.back() << "\n";
	}

	myOrders findOrder(string s) {
		if (s == "push")
			return myOrders::push;
		if (s == "pop")
			return myOrders::pop;
		if (s == "size")
			return myOrders::size;
		if (s == "empty")
			return myOrders::empty;
		if (s == "front")
			return myOrders::front;
		if (s == "back")
			return myOrders::back;
		return myOrders::Invalid;
	}

public:
	void order(string s) {
		myOrders m = findOrder(s);

		switch (m)
		{
		case myOrders::push:
			int num;
			cin >> num;
			push(num);
			break;
		case myOrders::pop:
			pop();
			break;
		case myOrders::size:
			size();
			break;
		case myOrders::empty:
			empty();
			break;
		case myOrders::front:
			front();
			break;
		case myOrders::back:
			back();
			break;
		default:
			break;
		}
	}
};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int N;
	cin >> N;

	myStack m;
	
	string s;
	while (N--) {
		cin >> s;
		m.order(s);
	}

	return 0;
}