def gen(factors, n):
    """
    return the first n number that is contained by the factors
    """
    result = [1]
    next_factor = [0] * len(factors)
    while len(result) < n:
        min_val = 999999999
        min_index = -1
        for i in range(len(factors)):
            if min_val > factors[i] * result[next_factor[i]]:
                min_val = factors[i] * result[next_factor[i]]
                min_index = i
        if result[-1] != min_val:
            result.append(min_val)
        next_factor[min_index] += 1
    return result



# test 
print gen([2, 3, 5, 7], 30)
