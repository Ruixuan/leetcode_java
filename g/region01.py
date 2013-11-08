def region_count(mat):
    m = len(mat)
    n = len(mat[0])
 
    for i in range(m):
        for j in range(n):
            if mat[i][j] == 1:
                continue
            if i == 0 or j == 0:
                mat[i][j] = -1
            elif mat[i][j - 1] == -1 or mat[i -1][j] == -1:
                mat[i][j] = -1
   
    for i in reversed(range(m)):
        for j in reversed(range(n)):
            if mat[i][j] == 1:
                continue
            if i == m - 1 or j == n - 1:
                mat[i][j] = -1
            elif mat[i][j + 1] == -1 or mat[i + 1][j] == -1:
                mat[i][j] = -1
    count = 0
    for i in range(m):
        j = 0
        while j < n:
            if mat[i][j] != 0:
                flag = 0
            else:
                flag = 1
            while mat[i][j] == 0 and j < n:
                if i > 0: 
                    if mat[i-1][j] == 0:
                        flag = 0
                j += 1  
            count += flag
            j = j + 1
    return count

#test
mat = [[0,0,1,1], [1,0,1,1], [1, 1,0, 0], [0,1,1,1]]
print region_count(mat)
