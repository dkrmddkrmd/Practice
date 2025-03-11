#include <iostream>

int main() {
	int N;
	int sum = 0, result = 0;
	std::cin >> N;

	// 즉 ab 면 ab + a + b = N 이 되는 ab를 찾는 것.

	for (int i = 1; i <= 1000054; i++)
	{
		if (i >= 1 && i < 10)
		{
			sum = i * 2;
			if (sum == N)
			{
				std::cout << i;
				result = 1;
				break;
			}
		}
		else if (i >= 10 && i < 100)
		{
			sum = i + (i % 10) + (i / 10);
			if (sum == N)
			{
				std::cout << i;
				result = 1;
				break;
			}
		}
		else if (i >= 100 && i < 1000)
		{
			sum = i + (i % 10) + ((i / 10) % 10) + (i / 100);
			if (sum == N)
			{
				std::cout << i;
				result = 1;
				break;
			}
		}
		else if (i >= 1000 && i < 10000)
		{
			sum = i + (i % 10) + ((i / 10) % 10) + ((i / 100) % 10) + (i / 1000);
			if (sum == N)
			{
				std::cout << i;
				result = 1;
				break;
			}
		}
		else if (i >= 10000 && i < 100000)
		{
			sum = i + (i % 10) + ((i / 10) % 10) + ((i / 100) % 10) + ((i / 1000) % 10) + (i / 10000);
			if (sum == N)
			{
				std::cout << i;
				result = 1;
				break;
			}
		}
		else
		{
			sum = i + (i % 10) + ((i / 10) % 10) + ((i / 100) % 10) + ((i / 1000) % 10) + ((i / 10000) % 10) + (i / 100000);
			if (sum == N)
			{
				std::cout << i;
				result = 1;
				break;
			}
		}
	}

	if (result == 0)
		std::cout << 0;

	return 0;
}