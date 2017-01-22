romans = {'I' : 1,    'IV' : 4,  'V' : 5,   'IX' : 9,  'X' : 10,   'XL' : 40,  'L' : 50,
          'XC' : 90, 'C' : 100, 'CD': 400, 'D' : 500, 'CM' : 900 ,'M' : 1000}
rev_roms = {v: k for k, v in romans.iteritems()}
vals = sorted(romans.values(), reverse = True)

def calc(s):
    sum = 0
    i = 0
    while i < len(s):
        if(i<len(s)-1):
            r1 = s[i]
            r2 = s[i+1]
            if romans.has_key(r1+""+r2):
                sum += romans[r1+""+r2]
                if i == len(s)-2:
                    break
                i+=2
            else:
                sum += romans[r1]
                i+=1
        else:
            sum += romans[s[i]]
            i+=1
    return sum
    
def enco(x):
    s = ''
    for val in vals:
        s = s + rev_roms[val]*(x/val)
        x = x%val
    return s

    
sum = 0    
while True:
    try:
        s = raw_input()
        t = enco(calc(s))
        sum += len(s)-len(t)
        print s, '->', calc(s), '->', t, '=', len(s)-len(t)
    except EOFError:
        break
        
print sum