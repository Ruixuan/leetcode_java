def max_summ(a):
    a.sort()
    return abs(a[2] - a[0]) + abs(a[0] - a[3]) + abs(a[3] - a[1])

#test 
print max_summ([5,3, -1, 4])
print max_summ([5,3, -1, 5])
