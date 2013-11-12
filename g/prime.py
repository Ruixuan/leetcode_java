def get_prime(n):
    nums = [i for i in range(0, n + 1)]
    i = 0
    nums[0] = -1
    nums[1] = -1
    while i < len(nums):
        if nums[i] != -1:
            curr = i
            j = curr * curr
            while j <= n:
                nums[j] = -1
                j += curr
        i += 1
    answer = list()
    for c in nums:
        if c != -1:
            answer.append(c)
    return answer

# test 
print get_prime(100)
