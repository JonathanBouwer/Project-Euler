from math import *
max_val = -1
for i in range(2, 1001):
	root = int(sqrt(i))
	if root*root == i:
		continue
	b = root
	c = 1
	
	v = []
	h = []
	k = []
	
	s = set()
	v.append(b)
	p = (b, c)
	
	while p not in s:
		s.add(p)
		
		temp_c = (i - b*b) / c
		temp_b = b
		d = -1
		while -temp_b <= root:  
			temp_b -= temp_c;
			d+=1
		temp_b += temp_c
		v.append(d)
		
		b = -temp_b
		c = temp_c
		
		p = (b, c)
	
	h.append(1)
	h.append(0)
	h.append(1)
	k.append(0)
	k.append(1)
	k.append(0)
	
	aIndex = 0
	while True:
		h.append(v[aIndex]*h[len(h)-1]+h[len(h)-2])
		k.append(v[aIndex]*k[len(k)-1]+k[len(k)-2])
		
		aIndex= 1 if aIndex+1>=len(v) else aIndex+1
		
		if h[-1]*h[-1] - i*k[-1]*k[-1] == 1:
			max_val = max(max_val, h[-1])
			print '{}^2 \n - {:>3}*{}^2\n={}\n'.format(h[-1], i, k[-1], h[-1]*h[-1] - i*k[-1]*k[-1]) 
			break

print "D=661"
print max_val, 
