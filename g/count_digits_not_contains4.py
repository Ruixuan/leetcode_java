
def lower(k):
    if k <= 4:
        return k
    else:
        return k - 1

def power(x, n):
    result = 1
    for _ in range(n):
        result *= x
    return result

def count_digit(n):
    digits = list()
    while(n != 0):
        digits.append(n % 10)
        n = n / 10
    digits.reverse() 
    l = len(digits)
    count = 0
    for i in range(l):
        count += lower(digits[i]) * power(9, l - i - 1)
        if digits[i] == 4:
            break
    return count

def cc(n):
    count = 0
    for i in range(0, n):
        s =str(i)
        if '4' not in s:
            count += 1
    return count

# test 
n  = 19587
print count_digit(n)
print cc(n)
