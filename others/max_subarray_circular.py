def max_circular_subarray(A):
    max_end = 0
    max_len = 0
    max_so_far = 0
    AA = A + A
    print AA
    n = len(A)
    for i in range(len(AA)):
        if max_len == n:
            max_len -= 1
            max_end -= AA[i - n]
        if max_end + AA[i] > 0:
            max_len += 1
            max_end = max_end + AA[i]
        else:
            max_len = 0
            max_end = 0
        max_so_far = max(max_end, max_so_far)
    return max_so_far
        
# test
A = [ 2, -3, 5, -9, 3 ]
print A
print max_circular_subarray(A)

