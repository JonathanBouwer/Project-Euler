#include <iostream>
#include <utility>
#include <algorithm>
#include <set>
#include <math.h>

using namespace std;
int main(){	
	int count = 0;
	for(int i = 2; i < 10000; i++) {
		int root = (int) sqrt(i);
		if(root*root == i) continue;
		int b = root;
		int c = 1;
		//cout << b << " " << c << "\n";
		
		set<pair<int, int>> s;
		pair<int, int> p = make_pair(b, c);
		while(s.find(p) == s.end()){
			s.insert(p);
			
			int temp_c = (i - b*b) / c; 
			int temp_b = b;
			while(-temp_b <= root) {
				temp_b -= temp_c;
			}
			temp_b += temp_c;
			
			b = -temp_b;
			c = temp_c;
			
			//cout << b << " " << c << "\n";
			p = make_pair(b, c);
		}
		
		//cout << i << ":" << s.size() << "\n";
		if(s.size()%2 == 1) count++;
	}
	
	cout << count << "\n";
	return 0;
}
