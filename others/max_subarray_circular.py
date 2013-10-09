def max_circular_subarray(A):
    max_end = 0
    max_so_far = 0
    for x in A:
        max_end = max(0, max_end + x)
        max_so_far = max( max_end, max_so_far)
    return max_so_far
        
# test
A = [ 2, -3, 5, 8, 0 ]
print A
print max_circular_subarray(A)

