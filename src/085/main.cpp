#include <iostream>

using namespace std;
int main() {
	int n = 1, m = 0, best = 2000000;
	while ((n*n + n) / 2 < 2500000) {
		while (true) {
			m++;
			auto val = (n*n + n)*(m*m + m) / 4;
			if (abs(2000000 - val) < best) {
				cout << n << "x" << m << " gives " << val << endl;
				cout << "area: " << n*m << endl;
				best = abs(2000000 - val);
			}
			if (val > 2000000) break;
		}
		m = 0;
		n++;
	}
	return 0;
}