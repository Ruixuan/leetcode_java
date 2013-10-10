def longest_rep_substring(s):
    print s
    n = len(s)
    dp = list()
    max_sofar = 0
    for i in range(n):
        dp.append([0] * n)
        for j in range(n):
            if i - 1 < 0 or j - 1 < 0:
                pre_len = 0
            else:
                pre_len = dp[i-1][j-1]

            if s[i] == s[j]:
                dp[i][j] = pre_len + 1
            else:
                dp[i][j] = 0
            #  determine over lap
            dist = abs(i - j)
            dp[i][j] = min(dist, dp[i][j])
            if max_sofar < dp[i][j]:
                max_sofar = dp[i][j]
    return max_sofar


# test 
print longest_rep_substring('abcdabc')
print longest_rep_substring('ababa')
