#include <iostream>
#include <numeric>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> primes;

void genPrimes(int n) {
	for(int i=0; i<n; i++) {
		primes.push_back(i);
	}
	
	for(int i=0; i < primes.size(); i++) {
		if(primes[i]>1) {
			for (int j = i*2; j < primes.size(); j+=i) {
				primes[j] = -1;
			}
		}
	}
	
	primes.erase(remove_if(primes.begin(), primes.end(), [](int i) -> bool{return i < 2;}), primes.end());
}

int totient(int n) {
	double product = n;
	if(binary_search (primes.begin(), primes.end(), n)) {
		//cout<< n << endl;
		return n-1;
	}
	int count = 0;
	for(int p: primes) {
		if(p>n || count > 0) break;
		
		if(n%p==0) {
			product*=(1-1.0/p);
			if(p*p>n) count++;
		}
	}
	return (int) (product);
}

bool isPerm(int a, int b) {
	int countsA[10] = {};
	int countsB[10] = {};
	
	while(a>0){
		countsA[a%10]++;
		a/=10;
	}
	
	while(b>0){
		countsB[b%10]++;
		b/=10;
	}
	
	for(int i=0; i<10; i++) {
		if(countsA[i] != countsB[i]) return false;
	}
	return true;
}

int main(){	
	int size = 10000000;
	double min = 1000000;
	genPrimes(size);
	
	for(int i=2; i<size; i++) {
		int tot = totient(i);
		if(isPerm(i, tot)) {
			double ratio = i/(double) tot;
			if(ratio < min) min = ratio;
			cout << i << "->" << tot << "=" << ratio << "\tmax:" << min << endl;
			
		}
	}
}
