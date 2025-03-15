#include <iostream>
#include <string>

int main() {
	int N, num = 0;
	int temp;
	std::string C;
	std::cin >> N;

	for (int i = 666; ; i++)
	{
		temp = i;
		while (temp != 0)
		{
			if (temp % 1000 == 666)
			{
				num++;
				break;
			}
			temp /= 10;
		}
		if (num == N)
		{
			std::cout << i;
			break;
		}
	}

	return 0;
}