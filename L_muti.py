def mutli_list(L):
    # return a list, where list[i] = L[0:i]*L[i+1:n] , n is the length of L
    n = len(L)
    L_front = [1 for _ in range(n)] # L_front[i] = L[0 ... i -1]
    L_back = [1 for _ in range(n)]  # L_back[i] = L[i+1 ... n-1]
    for i in range(1,n):
        L_front[i] = L_front[i-1] * L[i - 1]
        j = n - 1 - i
        L_back[j] = L_back[j + 1] * L[j + 1]
    return [ L_front[i] * L_back[i] for i in range(0,n)]

# test

L = [1,2,3,4,5,6,7]
s = 1
for i in L:
    s *= i

LL = [ s / i for i in L]
print LL
print mutli_list(L)
