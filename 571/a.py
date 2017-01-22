alphabet = [c for c in "0123456789abcd"]

def is_pandigital(n, k):
    vals = set(alphabet[0:k])
    for c in n:
        vals.discard(c)
        if len(vals) == 0:
            return True
    return False

def convert(n, b):
    s = []
    while n > 0:
        s.append(alphabet[n % b])
        n = n/b
    s.reverse()
    return "".join(s)


def get_perms(s, b):
    perms = set()
    if(len(s)==1):
        perms.add(s)
        return perms
    for i in range(len(s)):
        if b:
            if i==0:
                continue
        t = s[0:i]+s[i+1:]
        sub_perms = get_perms(t, False)
        for perm in sub_perms:
            perms.add(s[i]+perm)
    return perms

size = 10
sum = 0
count = 0

print "GENERATING PERMS"
tmp = get_perms("".join(alphabet[0:size]), True)

vals = []
for perm in tmp:
    vals.append(int(perm, size))

vals.sort()
print len(tmp), len(vals)
# print vals
# st = [i for i in tmp]
# st.sort()
# print st
print "START"
for perm in vals:
    for i in range(size-1):
        c = convert(perm, i+2)
        if not is_pandigital(c, i+2):
            break
    else:
        sum += perm
        count += 1
        print perm, ",count=", count
    if count>=10:
        break
print "sum=", sum