#define _CRT_SECURE_NO_WARNINGS
#include <iostream>


int main() {
	int a, b, c, d, e, f;
	int x, y;
	std::cin >> a >> b >> c >> d >> e >> f;

	x = (c * e - b * f) / (a * e - b * d);
	y = (c * d - a * f) / (b * d - a * e);

	printf("%d %d", x, y);

}