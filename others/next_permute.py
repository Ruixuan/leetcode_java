def next_permute(A):
    i = len(A) - 1
    while i > 0:
        if A[i] > A[i - 1]:
            break
        i -= 1

    if i == 0:
        return []
    result = A[i-1:]
    print result
    tmp = result[0]
    result[0] = result[1]
    result[1] = tmp
    result[1:] = sorted(result[1:])
    return A[:i-1] + result
    


# test
A = [1, 3, 4, 2]
print A
print next_permute(A)
