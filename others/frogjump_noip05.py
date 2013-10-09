def frog_jump(L,S,T,stones):
    """
    Calcular the min steps can be made in order to jump to the river
    suppose it starts at  0, ends at L
    """
    stones.append(0)
    stones.append(L)
    index = sorted(stones)
    m = len(index)
    dp = [0] * m
    begin = 0
    end = 0
    for i in range(1, m):
        # init the dp val in order to find the max
        dp[i] = L + 1
        # find the range of stones from which frog can jump to i
        while(index[begin] < index[i] - T):
            begin += 1
        while(index[end] <= index[i] - S):
            end += 1
        for j in range(begin, end):
            dp[i] = min(dp[i], dp[j] + 1)
    return dp[-1]

# test case
L = 10
S = 2
T = 3
stones = [2, 3, 5, 6, 7]
print frog_jump(L, S, T, stones) 
