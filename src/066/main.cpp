#include <iostream>
#include <utility>
#include <algorithm>
#include <set>
#include <vector>
#include <math.h>


//LIMITS OF LONG LONG CAUSE ERRORS, USE PYTHON CODE
using namespace std;
int main(){	
	for(int i = 2; i <= 1000; i++) {
		int root = (int) sqrt(i);
		if(root*root == i) continue;
		int b = root;
		int c = 1;
		
		//cout << i << "\n";
		vector<long long> v, h, k;
		set<pair<int, int>> s;
		pair<int, int> p = make_pair(b, c);
		v.push_back(b);
		while(s.find(p) == s.end()){
			s.insert(p);
			
			int temp_c = (i - b*b) / c; 
			int temp_b = b;
			int d = -1;
			while(-temp_b <= root) {
				temp_b -= temp_c;
				d++;
			}
			temp_b += temp_c;
			v.push_back(d);
			
			b = -temp_b;
			c = temp_c;
			
			p = make_pair(b, c);
		}
		
		h.push_back(1);
		h.push_back(0);
		h.push_back(1);
		k.push_back(0);
		k.push_back(1);
		k.push_back(0);
		
		//for(int q: v){
		//	cout << q << " ";
		//}
		//cout << "\n";
		int aIndex = 0;
		int count = 10;
		while(true){
			//cout << h.back() << "/" << k.back() << "\n";
			h.push_back(v[aIndex]*h[h.size()-1]+h[h.size()-2]);
			k.push_back(v[aIndex]*k[k.size()-1]+k[k.size()-2]);
			aIndex++;
			if(aIndex >= v.size()) aIndex = 1;
		
			if(h.back()*h.back() - i*k.back()*k.back() == 1) {
				cout << h.back() << "\t\t\t^2 - " << i << "*" << k.back() << "^2 = 1\n";
				break; 
			}
		}
	}
	return 0;
}
